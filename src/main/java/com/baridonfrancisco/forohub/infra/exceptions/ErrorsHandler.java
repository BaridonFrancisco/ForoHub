package com.baridonfrancisco.forohub.infra.exceptions;

import com.baridonfrancisco.forohub.domain.topic.validation.DuplicateFields;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.Field;
import java.util.List;


@RestControllerAdvice
public class ErrorsHandler {

    @ExceptionHandler({UserException.class})
    public ResponseEntity<?> userNotFound(UserException err){

       return ResponseEntity.status(404).body(new DataError("User",err.getMessage()));

    }

    @ExceptionHandler(TopicException.class)
    public ResponseEntity<?> topicNotFound(TopicException err){

        return ResponseEntity.status(404).body(new DataError("Topic",err.getMessage()));

    }

    @ExceptionHandler(CourseException.class)
    public ResponseEntity<?> courseNotFound(CourseException err){

        return ResponseEntity.status(404).body(new DataError("Course",err.getMessage()));

    }


    @ExceptionHandler(TopicDuplicated.class)
    public ResponseEntity<?> topicDuplicated(TopicDuplicated err){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataError("topic",err.getMessage()));

    }

    

    private record DataError(String field,String error) {
        public DataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
