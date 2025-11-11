package com.example.studentrecords.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,unique = true)
    private Integer age;
    @Column(nullable = false,unique = true)
    private Integer roll;
    @Column(nullable = true,length = 100)
    private String email;
    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollments> enrollments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "student_roles",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    public Set<Role> getRoles() {
        return roles;
    }
}
