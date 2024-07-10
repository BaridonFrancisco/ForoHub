package com.baridonfrancisco.forohub.domain.topic.validation;


import com.baridonfrancisco.forohub.domain.topic.TopicDTOUpdateData;
import com.baridonfrancisco.forohub.domain.topic.TopicData;
import com.baridonfrancisco.forohub.domain.topic.TopicRepository;
import com.baridonfrancisco.forohub.infra.exceptions.TopicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateFields implements Validation {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public <T> void validate(T t) {
        boolean res = false;
        if (t instanceof TopicData data) {
            res = topicRepository.existsByTitleIgnoreCaseAndMessageIgnoreCase(data.title(), data.message());

        }
        if (t instanceof TopicDTOUpdateData data) {
            res = topicRepository.existsByTitleIgnoreCaseAndMessageIgnoreCase(data.title(), data.message());

        }
        if (res) throw new TopicException("Topic and Message Duplicated");

    }
}
