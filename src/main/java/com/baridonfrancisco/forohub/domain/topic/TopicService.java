package com.baridonfrancisco.forohub.domain.topic;


import com.baridonfrancisco.forohub.domain.course.CourseRepository;
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

    public TopicDTOCreate  registerTopic(TopicData data){
        //TODO comprobar que no exista un topico con el mismo titulo y mensaje
        var user=userRepository.findById(data.user());
        var course=courseRepository.findByCourseNameIgnoreCase(data.course());
        if(course.isPresent() && user.isPresent()){
            Topic topic=new Topic(data,course.get(),user.get());
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

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
