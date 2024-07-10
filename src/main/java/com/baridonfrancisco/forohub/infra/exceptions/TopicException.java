package com.baridonfrancisco.forohub.infra.exceptions;

public class TopicException extends RuntimeException {

    public TopicException() {
    }

    public TopicException(String message) {
        super(message);
    }

    public TopicException(String message, Throwable cause) {
        super(message, cause);
    }

    public TopicException(Throwable cause) {
        super(cause);
    }

    public TopicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
