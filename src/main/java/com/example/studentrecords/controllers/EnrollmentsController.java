package com.example.studentrecords.controllers;

import com.example.studentrecords.dto.EnrollmentDto;
import com.example.studentrecords.dto.StudentCoursesDto;
import com.example.studentrecords.dto.StudentDto;
import com.example.studentrecords.services.EnrollmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentsController {
    private final EnrollmentsService enrollmentsService;
    public EnrollmentsController(EnrollmentsService enrollmentService){
        this.enrollmentsService=enrollmentService;
    }
    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(@RequestBody EnrollmentDto request) {
        enrollmentsService.enrollStudent(request);
        return ResponseEntity.ok("Enrollment successful");
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<StudentDto>> getStudentForCourse(@PathVariable Long courseId){
        List<StudentDto> students =this.enrollmentsService.getStudentsByCourseIdService(courseId);
        return ResponseEntity.ok(students);
    }
    @PreAuthorize("hasAnyAuthority('STUDENT','TEACHER')")
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentCoursesDto>> getStudentCourseByIdController(@PathVariable Long studentId){
       List<StudentCoursesDto> data = enrollmentsService.getStudentCoursesById(studentId);
        return ResponseEntity.ok(data);
    }

}
