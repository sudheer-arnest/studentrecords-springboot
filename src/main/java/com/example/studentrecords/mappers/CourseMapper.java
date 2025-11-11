package com.example.studentrecords.mappers;

import com.example.studentrecords.dto.CourseDto;
import com.example.studentrecords.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDto toDto(Course course){
        if(course ==null){
            return null;
        }
        CourseDto dto = new CourseDto();
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setCredits(course.getCredits());
        return  dto;

    }
    public static Course toEntity(CourseDto dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setCredits(dto.getCredits());
        return course;
    }
}
