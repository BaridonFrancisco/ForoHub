package com.baridonfrancisco.forohub.domain.topic.validation;

import com.baridonfrancisco.forohub.domain.course.Course;
import com.baridonfrancisco.forohub.domain.course.CourseRepository;

import java.util.Optional;

public class ValidateCourse implements Validation {

    CourseRepository courseRepository;

    @Override
    public <T> void validate(T t) {
        if(t instanceof Course){

        }
    }
}
