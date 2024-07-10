package com.baridonfrancisco.forohub.strategy;


import com.baridonfrancisco.forohub.domain.topic.TopicDTOCreate;
import com.baridonfrancisco.forohub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@DependsOn(value = "topicRepository")
public class TopicDuplicated implements Validation {

    /*String cade2;
    private String cadena;*/
    @Autowired
    private TopicRepository topicRepository;

    public TopicDuplicated() {
    }



/* public TopicDuplicated(String cadena,String cade2){
        this(null);
        this.cadena=cadena;
        this.cade2=cade2;
    }
    @Autowired
    public TopicDuplicated(@Autowired TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }*/

    @Override
    public void validate() {
        //boolean res = topicRepository.existsByTitleIgnoreCaseAndMessageIgnoreCase(this.title,this.message);
        //  if(res) throw new TopicException("Title or Message Duplicated");
        if (this.topicRepository != null) {
            System.out.println("No esta nulo");
        } else {
            System.out.println("Esta nulo");
        }
        System.out.println("FINNNN");

    }
}
