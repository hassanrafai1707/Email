package com.example.Emailtest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Emailtest.Domain.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public Student findByEmail(String email);
    public Boolean existsByEmail(String email);
}
