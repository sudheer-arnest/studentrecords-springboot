package com.example.studentrecords.repository;

import com.example.studentrecords.dto.StudentDto;
import com.example.studentrecords.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT new com.example.studentrecords.dto.StudentDto(s.name, s.email, s.roll, s.age) FROM Student s WHERE s.age > :age")
    List<StudentDto> findStudentOlderThan(@Param("age") Long age);
    @Query(value ="SELECT * FROM students s WHERE s.roll=:roll LIMIT 1",nativeQuery=true)
    Student getStudentByRollNumberRepository(@Param("roll") Long roll);
    @Query(value = "SELECT * FROM students s WHERE s.email=:email",nativeQuery = true )
    Student getStudentByEmail(@Param("email") String email);
    @Query(value = "SELECT * FROM students s WHERE s.id=:id",nativeQuery = true )
    Student getStudentById(@Param("email") int id);
}

