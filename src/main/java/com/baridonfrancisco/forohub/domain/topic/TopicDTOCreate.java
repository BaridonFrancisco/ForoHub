package com.baridonfrancisco.forohub.domain.topic;

import com.baridonfrancisco.forohub.domain.course.Category;

import java.time.LocalDateTime;

public record TopicDTOCreate(

        Long authorId,
        Long courseId,
        String title,
        String message,
        String status,
        String course,
        Category category,
        LocalDateTime date

) {
}
