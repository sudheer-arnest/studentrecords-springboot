package com.example.studentrecords.controllers;

import com.example.studentrecords.dto.CourseDto;
import com.example.studentrecords.model.Course;
import com.example.studentrecords.services.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;
    public  CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addNewCourseController(@Valid  @RequestBody CourseDto course){
         this.courseService.addCourseService(course);
         return ResponseEntity.ok("Course Added SuccessFully");
    }
    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseByIdController(@PathVariable int id){
        CourseDto course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(404).build();
        }
        return  ResponseEntity.ok(course);
    }

    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN','STUDENT')")
    @GetMapping
    public ResponseEntity<List<CourseDto>> getCoursesController(){
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
}
