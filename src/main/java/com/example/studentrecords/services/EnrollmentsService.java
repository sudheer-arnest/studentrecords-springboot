package com.example.studentrecords.services;

import com.example.studentrecords.dto.EnrollmentDto;
import com.example.studentrecords.dto.StudentCoursesDto;
import com.example.studentrecords.dto.StudentDto;
import com.example.studentrecords.exceptions.EnrollmentsException;
import com.example.studentrecords.mappers.EnrollmentMapper;
import com.example.studentrecords.model.Course;
import com.example.studentrecords.model.Enrollments;
import com.example.studentrecords.model.Student;
import com.example.studentrecords.repository.CourseRepository;
import com.example.studentrecords.repository.EnrollmentsRepository;
import com.example.studentrecords.repository.JdbcRepository;
import com.example.studentrecords.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentsService {
    private final EnrollmentsRepository repository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final JdbcRepository jdbcRepository;
    private final EnrollmentMapper enrollmentMapper;
    public EnrollmentsService(EnrollmentsRepository repository,CourseRepository courseRepository,StudentRepository studentRepository,JdbcRepository jdbcRepository,EnrollmentMapper enrollmentMapper){
        this.repository=repository;
        this.courseRepository=courseRepository;
        this.studentRepository=studentRepository;
        this.jdbcRepository = jdbcRepository;
        this.enrollmentMapper=enrollmentMapper;
    }
    public void enrollStudent(EnrollmentDto request) {
        Student student = this.studentRepository.findById(request.getStudent())
                .orElseThrow(() -> EnrollmentsException.enrollmentNotFound("Student Not Found With Id "+request.getStudent()));
        Course course = this.courseRepository.findById(request.getCourse())
                .orElseThrow(() -> EnrollmentsException.enrollmentNotFound("Course Not Found with Id "+request.getCourse()));
        Optional<Enrollments> existingEnrollment = this.repository.findByStudentIdAndCourseId(request.getStudent(),request.getCourse());
        if(existingEnrollment.isPresent()){
            throw EnrollmentsException.enrollmentAlreadyExists(request.getStudent(), request.getCourse());
        }
        Enrollments enrollment = enrollmentMapper.toEntity(request, student, course);
        this.repository.save(enrollment);
    }
    public List<StudentDto> getStudentsByCourseIdService(Long courseId){
        List<Student> students = this.repository.findStudentByCourseId(courseId);
        System.out.println(students);
        return students.stream()
                .map(student -> new StudentDto(student.getName(),student.getEmail(),student.getAge(),student.getRoll()))
                .collect(Collectors.toList());
    }
    public List<StudentCoursesDto> getStudentCoursesById(Long studentId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> EnrollmentsException.enrollmentNotFound("Student Not Found With Id " + studentId));
        List<StudentCoursesDto> data = jdbcRepository.getStudentCoursesById(studentId);
        if(data.isEmpty()){
            throw EnrollmentsException.enrollmentNotFound("No Enrollments Found for Student "+studentId);
        }
        return  data;
    }
}
