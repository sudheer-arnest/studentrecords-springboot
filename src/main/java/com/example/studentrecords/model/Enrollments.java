package com.example.studentrecords.model;


import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"student", "course"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name = "enrollments")
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    @Column(name = "enrolled_date")
    private LocalDate enrollmentDate;
    @Column(length = 4,name = "grade_id",nullable = true)
    private int grade;
    @PrePersist
    protected void onCreate() {
        this.enrollmentDate = LocalDate.now();
    }
}

