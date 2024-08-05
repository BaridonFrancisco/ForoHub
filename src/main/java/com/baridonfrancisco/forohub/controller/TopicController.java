package com.baridonfrancisco.forohub.controller;


import com.baridonfrancisco.forohub.domain.topic.*;
import com.baridonfrancisco.forohub.domain.topic.dto.TopicDTOUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Transactional
    public ResponseEntity<TopicDTOGet> getTopicById(@PathVariable Long id){
        return ResponseEntity.ok(topicService.getTopic(id));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<TopicDTOGet>> getAllTopics(){
        var topics=topicService.getAllTopics();
        return ResponseEntity.ok(topics);

    }


    // modificar topico
    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("authentication.principal.id == #data.user")
    public ResponseEntity<TopicDTOUpdate> updateTopic(@RequestBody TopicDTOUpdateData data, @PathVariable Long id){
        var topic=topicService.updateTopic(data,id);
        return ResponseEntity.status(200).body(topic);
    }



    // eliminar topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Topic> deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}
