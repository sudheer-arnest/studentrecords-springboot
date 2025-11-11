package com.example.studentrecords.repository;

import com.example.studentrecords.dto.CourseDto;
import com.example.studentrecords.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Procedure(name = "Course.getCourseById")
    Course getCourseById(@Param("courseId_param") int courseId);
}
