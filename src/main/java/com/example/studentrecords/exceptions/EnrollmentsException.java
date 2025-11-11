package com.example.studentrecords.exceptions;

import org.springframework.http.HttpStatus;

public class EnrollmentsException extends RuntimeException{
    private final HttpStatus status;
    public  EnrollmentsException(String message,HttpStatus status){
        super(message);
        this.status=status;
    }

    public static EnrollmentsException enrollmentAlreadyExists(Long studentId,Long courseId){
        return new EnrollmentsException("Enrollment already exists with student Id"+studentId+" course id "+courseId,HttpStatus.CONFLICT);
    }
    public static EnrollmentsException enrollmentNotFound(String message){
        return new EnrollmentsException(message,HttpStatus.NOT_FOUND);
    }
}
