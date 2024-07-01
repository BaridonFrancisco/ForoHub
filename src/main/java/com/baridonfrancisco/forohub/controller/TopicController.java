package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.domain.topic.TopicDTOCreate;
import com.baridonfrancisco.forohub.domain.topic.TopicData;
import com.baridonfrancisco.forohub.domain.topic.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;
    //registra un topico
    /*
    * */
    @PostMapping
    @Transactional
    public ResponseEntity<TopicDTOCreate> registerTopic(@RequestBody @Valid TopicData topicData){
       var re= topicService.registerTopic(topicData);
        return ResponseEntity.status(201)
                .body(re);

    }
    // obtiene un topico por el id
    public void getTopicById(){

    }
    // modificar topico


    // eliminar topico

}
