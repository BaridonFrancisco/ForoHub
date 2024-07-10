package com.baridonfrancisco.forohub.strategy;

import com.baridonfrancisco.forohub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class strategyConfig {
   // @Autowired
    private TopicRepository topicRepository;

  //@Bean
    public Validation topicDuplicatedValidation() {
        //return new TopicDuplicated(topicRepository);
        return null;
    }
}
