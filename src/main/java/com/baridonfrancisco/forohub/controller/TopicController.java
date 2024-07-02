package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.domain.topic.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public void getTopicById(@PathVariable Long id){

    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<TopicDTOGet>> getAllTopics(){
        var topics=topicService.getAllTopics();
        return ResponseEntity.ok(topics);

    }

    // modificar topico

    // eliminar topico
    @DeleteMapping("{id}")
    @Transactional
    public void deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
    }

}
