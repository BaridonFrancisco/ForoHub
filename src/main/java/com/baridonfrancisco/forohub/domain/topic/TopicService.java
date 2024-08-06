package com.baridonfrancisco.forohub.domain.topic;


import com.baridonfrancisco.forohub.domain.course.CourseRepository;
import com.baridonfrancisco.forohub.domain.topic.dto.TopicDTOUpdate;
import com.baridonfrancisco.forohub.domain.topic.validation.DuplicateFields;
import com.baridonfrancisco.forohub.domain.user.User;
import com.baridonfrancisco.forohub.domain.user.UserRepository;
import com.baridonfrancisco.forohub.infra.exceptions.CourseException;
import com.baridonfrancisco.forohub.infra.exceptions.TopicException;
import com.baridonfrancisco.forohub.infra.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


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


    public void deleteTopic(Long id) {
       // if(!topicRepository.existsById(id))throw new TopicException("Id not exists");
        //Topic topic=topicRepository.getReferenceById(id);
        //System.out.println("Entrando");
        //System.out.println(topic);
        //topicRepository.delete(topic);
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new TopicException("el topico "+id+" no existe"));
        checkTopicsUser(topic);
        topic.setTopic_status(Topic_Status.DISABLED);
        System.out.println(topic);
        topicRepository.save(topic);
        //topicRepository.delete(topic);
    }

    public TopicDTOGet getTopic(Long id) {
        //mostrar un mensaje que esta deshabilidao
        // mostrar un mensaje que no lo encontro
        
        checkId(id);

        Topic topic=topicRepository.findById(id)
                .orElseThrow(()->new TopicException("Topic not Found"));

        if(topic.getTopic_status().equals(Topic_Status.DISABLED)){
            throw new TopicException("The topic be disabled contact to admin");
        }

        return Optional.of(topic).map(TopicDTOGet::new)
               .orElseThrow(()->new TopicException("Topic not Found"));

    }

    public TopicDTOUpdate updateTopic(TopicDTOUpdateData data, Long id) {
        // si no existe el id es vano hacer las otras operaciones
        var user = userRepository.findById(data.user());

        //verifica si el topico pertenece al usuario

        duplicateFields.validate(data);
        var course = courseRepository.findByCourseNameIgnoreCase(data.course());
        var topic = topicRepository.findById(id);

        topic.ifPresent(this::checkTopicsUser);
        
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
    // comprueba si el usuario tiene ese topico con su id
    private void checkTopicsUser(Topic topic) {
        String userName = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        Long idUser = userRepository.findByUserName(userName)
                .map(User::getId)
                .orElse(0L);
        if (!Objects.equals(topic.getUser().getId(), idUser)) {
            throw new UserException("No puede cambiar el topico de otro usuario");
        }
    }
    private void checkId(Long id){
        if(id<=0)throw new TopicException("Number id:"+id+" is not valid");
    }

}
