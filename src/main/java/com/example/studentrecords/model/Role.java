package com.example.studentrecords.model;


import lombok.*;

import jakarta.persistence.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_type",nullable = false)
    private String roleType;
    @ManyToMany(mappedBy = "roles")
    private Set<Student> students;

    public String getRoleType() {
        return roleType;
    }
}
