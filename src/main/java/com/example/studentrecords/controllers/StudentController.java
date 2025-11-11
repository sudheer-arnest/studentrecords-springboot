package com.example.studentrecords.controllers;

import com.example.studentrecords.dto.StudentDto;
import com.example.studentrecords.model.Student;
import com.example.studentrecords.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @GetMapping
    public List<StudentDto> getStudents(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size) {
        return this.studentService.getAllStudents(page,size);
    }
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        this.studentService.createNewStudent(student);
        return ResponseEntity.ok("Student Record Successfully Added");
    }

    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return this.studentService.getStudentById(id);
    }
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN','STUDENT')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudentName(@PathVariable Long id, @RequestBody Student studentData) {
         this.studentService.updateStudentData(id, studentData);
         return ResponseEntity.ok("Student Updated successfully");
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
         this.studentService.deleteStudentById(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/older/{age}")
    public List<StudentDto> getStudentsOlderthan(@PathVariable Long age){
        return this.studentService.getStudentsOlderthan(age);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("/roll/{roll}")
    public  StudentDto getStudentByRollNumber(@PathVariable Long roll){
        return this.studentService.getStudentByRollNumberService(roll);
    }
}



