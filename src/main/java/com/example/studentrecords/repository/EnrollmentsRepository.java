package com.example.studentrecords.repository;

import com.example.studentrecords.model.Enrollments;
import com.example.studentrecords.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnrollmentsRepository extends JpaRepository<Enrollments,Long> {
    @Query("SELECT e FROM Enrollments e where e.student.id =:studentId AND e.course.id=:courseId")
    Optional<Enrollments> findByStudentIdAndCourseId(@Param("studentId") Long studentId,@Param("courseId") Long courseId);
    @Query("SELECT e.student FROM Enrollments e where e.course.id=:courseId")
    List<Student> findStudentByCourseId(@Param("courseId") Long courseId);
}
