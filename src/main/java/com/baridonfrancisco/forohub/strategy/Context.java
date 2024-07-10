package com.baridonfrancisco.forohub.strategy;


import com.baridonfrancisco.forohub.domain.topic.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class Context {


    private Validation validation;


    @Autowired
    public void setValidation(Validation validation) {
        this.validation = validation;
    }


    public void validate() {
        if (this.validation != null) {
            this.validation.validate();
            return;
        }
        throw new RuntimeException("validacion nula");
    }

}
