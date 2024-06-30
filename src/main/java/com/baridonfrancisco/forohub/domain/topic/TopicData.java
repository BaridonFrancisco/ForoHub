package com.baridonfrancisco.forohub.domain.topic;

import com.baridonfrancisco.forohub.domain.user.User;


/*los datos que se envian en el body*/
public record TopicData(

        String title,
        String message,
        User user,
        String courseName

) {
}
