package com.baridonfrancisco.forohub.domain.topic;


import com.baridonfrancisco.forohub.domain.course.CourseRepository;
import com.baridonfrancisco.forohub.domain.topic.dto.TopicDTOUpdate;
import com.baridonfrancisco.forohub.domain.topic.validation.DuplicateFields;
import com.baridonfrancisco.forohub.domain.user.UserRepository;
import com.baridonfrancisco.forohub.infra.exceptions.CourseException;
import com.baridonfrancisco.forohub.infra.exceptions.TopicException;
import com.baridonfrancisco.forohub.infra.exceptions.UserException;
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
        duplicateFields.validate(data);
        var user = userRepository.findById(data.user()).orElseThrow(()->new UserException("User not Found"));
        var course = courseRepository.findByCourseNameIgnoreCase(data.course()).orElseThrow(()->new CourseException("Course not Found"));

        Topic topic = new Topic(data, course, user);
        topic.setMessage(removeBlank(topic.getMessage()));
        topic.setTitle(removeBlank(topic.getTitle()));
        var topicDb = topicRepository.save(topic);
        return new TopicDTOCreate(topicDb.getUser().getId(),
                course.getId(),
                topicDb.getTitle(),
                topicDb.getMessage(),
                topicDb.getTopic_status().name(),
                course.getCourseName(), course.getCategory(), topicDb.getCreationTime());


    }

    public List<TopicDTOGet> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(TopicDTOGet::new)
                .toList();
    }

    //TODO modificar implementar borrado logico
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
                newTopic.setTitle(removeBlank(data.title()));
            }
            if (data.message() != null && !data.message().isBlank()) {
                newTopic.setMessage(removeBlank(data.message()));
            }
            user.ifPresent(newTopic::setUser);
            return newTopic;
        }).orElseThrow(()-> new TopicException("Topic not found"));
        topicRepository.save(topicDb);
        return new TopicDTOUpdate(topicDb.getTitle(), topicDb.getMessage(), topicDb.getUser().getId(), topicDb.getCourse().getCourseName());


    }

    private String removeBlank(String str){
       return str.replaceAll("^\\s+|\\s+$","");
    }


}
