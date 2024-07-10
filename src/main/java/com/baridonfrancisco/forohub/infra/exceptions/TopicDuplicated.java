package com.baridonfrancisco.forohub.infra.exceptions;



public class TopicDuplicated extends RuntimeException {



    public TopicDuplicated() {
    }

    public TopicDuplicated(String message) {
        super(message);
    }

    public TopicDuplicated(String message, Throwable cause) {
        super(message, cause);
    }

    public TopicDuplicated(Throwable cause) {
        super(cause);
    }

    public TopicDuplicated(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
