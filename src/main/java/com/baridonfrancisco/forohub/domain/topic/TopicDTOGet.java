package com.baridonfrancisco.forohub.domain.topic;

import com.baridonfrancisco.forohub.domain.response.Response;

import java.time.LocalDateTime;
import java.util.List;

public record TopicDTOGet(
        Long id,
        String author,
        String title,
        String message,
        LocalDateTime date,
        Topic_Status status,
        String course,
        List<Response> responses

) {
    public TopicDTOGet(Topic topic){
        this(topic.getId(),topic.getUser().getUsername(),topic.getTitle(),topic.getMessage(),topic.getCreationTime(),topic.getTopic_status(),topic.getCourse().getCourseName(),topic.getListResponses());
    }


}
