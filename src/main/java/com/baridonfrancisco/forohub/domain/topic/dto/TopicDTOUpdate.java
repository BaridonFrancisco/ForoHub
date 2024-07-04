package com.baridonfrancisco.forohub.domain.topic.dto;



public record TopicDTOUpdate(

        String title,
        String message,
        Long user,
        String course

) {
}
