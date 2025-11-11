package com.example.studentrecords.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentCoursesDto {
    private int course_id;
    private String title;
    private int credits;
    private String grade;
    private String description;
}
