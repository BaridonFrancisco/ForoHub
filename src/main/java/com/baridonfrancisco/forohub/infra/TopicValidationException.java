package com.baridonfrancisco.forohub.infra;

public class TopicValidationException extends RuntimeException {

    public TopicValidationException() {
    }

    public TopicValidationException(String message) {
        super(message);
    }

    public TopicValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TopicValidationException(Throwable cause) {
        super(cause);
    }

    public TopicValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
