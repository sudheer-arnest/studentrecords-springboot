package com.example.studentrecords.exceptions;

import org.springframework.http.HttpStatus;

public class CourseException extends RuntimeException {
    private final HttpStatus httpStatus;
    public CourseException(String message,HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static CourseException courseNotFound(Integer courseId){
        return new CourseException("Course Not Found With Id : "+courseId, HttpStatus.NOT_FOUND);
    }
    public static CourseException courseAlreadyFound(String courseName){
        return new CourseException("Course Already Found With Name : "+courseName,HttpStatus.CONFLICT);
    }
}
