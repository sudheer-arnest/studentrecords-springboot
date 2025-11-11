package com.example.studentrecords.repository;

import com.example.studentrecords.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleType(String roleType);
}
