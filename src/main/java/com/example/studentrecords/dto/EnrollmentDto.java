package com.example.studentrecords.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EnrollmentDto {
    private Long student;
    private Long course;
    @Column(name = "grade_id")
    private int grade;
}
