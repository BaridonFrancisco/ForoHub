package com.baridonfrancisco.forohub.domain.topic;




public record TopicDTOUpdateData(
        String title,
        String message,
        Long user,
        String course

) {
}
