package com.example.studentrecords.security;

import com.example.studentrecords.model.Student;
import com.example.studentrecords.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomStudentDetailsService implements UserDetailsService {

    private  StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Student student = studentRepository.getStudentByEmail(usernameOrEmail);
        if (student == null) {
            throw new UsernameNotFoundException("Student not found with email: " + usernameOrEmail);
        }
        Set<GrantedAuthority> authorities = student.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getRoleType()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                student.getPassword(),
                authorities
        );
    }
}
