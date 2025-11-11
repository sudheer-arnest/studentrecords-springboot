package com.example.studentrecords.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id,String type){
        super("Student with "+type+" "+id+" not found");
    }
}
