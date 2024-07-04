package com.baridonfrancisco.forohub.domain.topic;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/*los datos que se envian en el body*/
public record TopicData(

       @NotBlank String title,
       @NotBlank String message,
       @NotNull Long user,
       @NotBlank String course

) {
}
