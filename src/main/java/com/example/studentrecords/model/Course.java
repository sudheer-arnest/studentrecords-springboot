package com.example.studentrecords.model;


import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name="course")
@NamedStoredProcedureQuery(
        name = "Course.getCourseById",
        procedureName = "get_course_by_id",
        resultClasses = Course.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "courseId_param",type = Integer.class)
        }
)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 60,unique = true)
    private String title;
    @Column(length = 200)
    private String description;
    @Column(nullable = false,unique = true)
    private Integer credits;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    List<Enrollments> enrollments;
}
