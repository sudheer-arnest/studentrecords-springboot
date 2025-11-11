package com.example.studentrecords.mappers;

import com.example.studentrecords.dto.EnrollmentDto;
import com.example.studentrecords.model.Course;
import com.example.studentrecords.model.Enrollments;
import com.example.studentrecords.model.Student;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {
    public EnrollmentDto toDto(Enrollments enrollments){
        if(enrollments ==null){
            return null;
        }
        EnrollmentDto dto = new EnrollmentDto();
        dto.setCourse(enrollments.getCourse().getId());
        dto.setStudent(enrollments.getStudent().getId());
        dto.setGrade(enrollments.getGrade());
        return dto;
    }
    public Enrollments toEntity(EnrollmentDto dto, Student student, Course course) {
        if(dto == null) return null;
        Enrollments enrollment = new Enrollments();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setGrade(dto.getGrade());
        return enrollment;
    }
}
