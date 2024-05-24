package io.aston.hibernatetask.exception;

public class FailedToReceiveSessionFactory extends RuntimeException {
    public FailedToReceiveSessionFactory(String message) {
        super(message);
    }
}
