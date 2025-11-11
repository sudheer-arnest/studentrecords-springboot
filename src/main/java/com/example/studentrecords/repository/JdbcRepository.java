package com.example.studentrecords.repository;

import com.example.studentrecords.dto.CourseDto;
import com.example.studentrecords.dto.StudentCoursesDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;

@Repository
public class JdbcRepository {
    private final JdbcTemplate jdbcTemplate;
    public  JdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<CourseDto> getAllCourses(){
        String query = "SELECT * FROM course";
        try {
            return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(CourseDto.class));
        }catch (DataAccessException e){
            return Collections.emptyList();
        }
    }
    public List<StudentCoursesDto> getStudentCoursesById(Long id) {
        String query = """
        SELECT c.id AS course_id, c.title, c.credits, g.grade, c.description
        FROM course c
        JOIN enrollments e ON c.id = e.course_id
        JOIN StudentRecords.grades g on g.id=e.grade_id
        WHERE e.student_id = ?
    """;

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            StudentCoursesDto dto = new StudentCoursesDto();
            dto.setCourse_id(rs.getInt("course_id"));
            dto.setTitle(rs.getString("title"));
            dto.setCredits(rs.getInt("credits"));
            dto.setGrade(rs.getString("grade"));
            dto.setDescription(rs.getString("description"));
            return dto;
        }, id);
    }
    public List<CourseDto> getCourseByTitle(String title){
        String query = "SELECT * FROM course c WHERE c.title=? ";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(CourseDto.class),title);
    }

}
