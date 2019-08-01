package com.luanphm.CourseManagement.exception_handling.CustomExceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String exception) {
        super(exception);
    }
}
