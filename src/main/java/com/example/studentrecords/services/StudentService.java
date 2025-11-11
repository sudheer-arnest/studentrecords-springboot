package com.example.studentrecords.services;


import com.example.studentrecords.dto.StudentDto;
import com.example.studentrecords.exceptions.StudentNotFoundException;
import com.example.studentrecords.model.Role;
import com.example.studentrecords.model.Student;
import com.example.studentrecords.repository.RoleRepository;
import com.example.studentrecords.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository repository,RoleRepository roleRepository,PasswordEncoder passwordEncoder){
        this.repository=repository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public List<StudentDto> getAllStudents(int page,int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return this.repository.findAll(pageable).stream()
                .map(student-> new StudentDto(student.getName(),student.getEmail(),student.getRoll(),student.getAge()))
                .collect(Collectors.toList());
    }
    public void createNewStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        Set<Role> attachedRoles = student.getRoles().stream()
                .map(role -> roleRepository.findById(role.getId())
                        .orElseThrow(() -> new RuntimeException("Role not found: " + role.getId())))
                .collect(Collectors.toSet());

        student.setRoles(attachedRoles);
        repository.save(student);
    }

    public StudentDto getStudentById(Long id){
        Student student = this.repository.findById(id).orElseThrow(()-> new StudentNotFoundException(id,"id"));
        return  new StudentDto(student.getName(),student.getEmail(),student.getAge(),student.getRoll());
    }
    @Transactional
    public void updateStudentData(Long id ,Student student){
        Student existingStudent = this.repository.findById(id).orElseThrow(()-> new StudentNotFoundException(id,"id"));
        existingStudent.setEmail(student.getEmail());
        existingStudent.setName(student.getName());
        this.repository.save(existingStudent);
    }
    public  void deleteStudentById(Long id){
        if(!repository.existsById(id)){
            throw new StudentNotFoundException(id,"id");
        }
        this.repository.deleteById(id);
    }
    public List<StudentDto> getStudentsOlderthan(Long age){
        return this.repository.findStudentOlderThan(age);
    }
    public StudentDto getStudentByRollNumberService(Long roll){
        Student student = this.repository.getStudentByRollNumberRepository(roll);
        if (student ==null){
            throw new StudentNotFoundException(roll," roll");
        }
        return new StudentDto(student.getName(),student.getEmail(),student.getRoll(),student.getAge());
    }
}
