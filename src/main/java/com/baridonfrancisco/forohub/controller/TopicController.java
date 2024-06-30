package com.baridonfrancisco.forohub.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

    //registra un topico
    /*
    * */
    @PostMapping
    @Transactional
    public void registerTopic(){

    }
    // obtiene un topico por el id
    public void getTopicById(){

    }
    // modificar topico


    // eliminar topico

}
