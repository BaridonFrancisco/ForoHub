package com.baridonfrancisco.forohub.domain.topic;


import com.baridonfrancisco.forohub.domain.course.Course;
import com.baridonfrancisco.forohub.domain.course.CourseRepository;
import com.baridonfrancisco.forohub.domain.topic.dto.TopicDTOUpdate;
import com.baridonfrancisco.forohub.domain.topic.validation.DuplicateFields;
import com.baridonfrancisco.forohub.domain.user.User;
import com.baridonfrancisco.forohub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DuplicateFields duplicateFields;

    public TopicDTOCreate  registerTopic(TopicData data){

        var user=userRepository.findById(data.user());
        var course=courseRepository.findByCourseNameIgnoreCase(data.course());

        duplicateFields.validate(data);

        if(course.isPresent() && user.isPresent()){
            Topic topic=new Topic(data,course.get(),user.get());
            topic.setMessage(removeBlank(topic.getMessage()));
            topic.setTitle(removeBlank(topic.getTitle()));
            var topicDb = topicRepository.save(topic);
            return new TopicDTOCreate(topicDb.getUser().getId(),
                    course.get().getId(),
                    topicDb.getTitle(),
                    topicDb.getMessage(),
                    topicDb.getTopic_status().name(),
                    course.get().getCourseName(),course.get().getCategory(),topicDb.getCreationTime());
        }
        throw new RuntimeException("Course or User not found");

    }

    public List<TopicDTOGet> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(TopicDTOGet::new)
                .toList();
    }

    //TODO modificar
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    public TopicDTOGet getTopic(Long id) {
        return topicRepository.findById(id)
               .map(TopicDTOGet::new)
               .orElseThrow(RuntimeException::new);

    }

    public TopicDTOUpdate updateTopic(TopicDTOUpdateData data, Long id) {
        // si no existe el id es vano hacer las otras operaciones

        var user = userRepository.findById(data.user());
        duplicateFields.validate(data);
        var course = courseRepository.findByCourseNameIgnoreCase(data.course());
        var topic = topicRepository.findById(id);

        var topicDb = topic.map(newTopic -> {
            course.ifPresent(newTopic::setCourse);

            if (data.title() != null && !data.title().isBlank()) {
                newTopic.setTitle(data.title());
            }
            if (data.message() != null && !data.message().isBlank()) {
                newTopic.setMessage(data.message());
            }
            user.ifPresent(newTopic::setUser);
            return newTopic;
        }).orElseThrow(RuntimeException::new);
        topicRepository.save(topicDb);
        return new TopicDTOUpdate(topicDb.getTitle(), topicDb.getMessage(), topicDb.getUser().getId(), topicDb.getCourse().getCourseName());


    }

    public Course checkCourse(String courseName){
        return courseRepository.findByCourseNameIgnoreCase(courseName)
                .orElse(null);
    }
    public User checkUser(Long id){
        return userRepository.findById(id)
                .orElse(null);
    }
    public String removeBlank(String str){
       return str.replaceAll("^\\s+|\\s+$","");
    }


}
