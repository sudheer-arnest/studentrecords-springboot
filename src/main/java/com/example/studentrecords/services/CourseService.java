package com.example.studentrecords.services;

import com.example.studentrecords.dto.CourseDto;
import com.example.studentrecords.exceptions.CourseException;
//import com.example.studentrecords.mappers.CourseMapper;
import com.example.studentrecords.exceptions.EnrollmentsException;
import com.example.studentrecords.mappers.CourseMapper;
import com.example.studentrecords.model.Course;
import com.example.studentrecords.repository.CourseRepository;
import com.example.studentrecords.repository.JdbcRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CourseService {
    @Autowired
    private final CourseRepository repository;
    private final JdbcRepository jdbcRepository;
    private final CourseMapper courseMapper;
    @PersistenceContext
    private EntityManager entityManager;

     public CourseService(CourseRepository repository, JdbcRepository jdbcRepository,CourseMapper courseMapper){
         this.repository=repository;
         this.jdbcRepository=jdbcRepository;
         this.courseMapper=courseMapper;
     }
     public Course addCourseService(CourseDto course)
     {
         List<CourseDto> isExists = jdbcRepository.getCourseByTitle(course.getTitle());
         if(!isExists.isEmpty()){
             throw  CourseException.courseAlreadyFound(course.getTitle());
         }
         Course courseEntity = courseMapper.toEntity(course);
       return  this.repository.save(courseEntity);
     }
     @Transactional
     public CourseDto getCourseById(int courseId){
         Course course= this.repository.getCourseById(courseId);
         if(course == null){
             throw CourseException.courseNotFound(courseId);
         }
           return courseMapper.toDto(course);
     }
     public List<CourseDto> getAllCourses(){
         List<CourseDto> courses = jdbcRepository.getAllCourses();
         if(courses.isEmpty()){
             throw new RuntimeException("No CoursesFound");
         }
         return courses;
     }
}
