package com.example.Emailtest.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Emailtest.Domain.Conformation;
import com.example.Emailtest.Domain.Student;
import com.example.Emailtest.Repository.ConformationRepository;
import com.example.Emailtest.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ConformationRepository conformationRepository;
    private final EmailService emailService;
    private final PerformanceService performanceService;

    public Student saveStudent(Student student){
        if(studentRepository.existsByEmail(student.getEmail())){
        throw new RuntimeException("Email already taken");
        }
        student.setEnable(false);
        studentRepository.save(student);
        Conformation conformation =new Conformation(student);
        conformationRepository.save(conformation);
        emailService.sendVerifyEmail(student.getEmail(), student.getName(), conformation.getToken());
        performanceService.createDefault(student);
    return student;
    }
    public Boolean verifyToken(String token){
        Conformation conformation=conformationRepository.findByToken(token);
        if(conformation == null){
            return Boolean.FALSE;
        }
        Student student=conformation.getStudent();
        student.setEnable(true);
        studentRepository.save(student);
        return Boolean.TRUE;
    }
    public Student valaiDateLogin(String email, String password){
        Student student =studentRepository.findByEmail(email);
        if(student==null || !student.getPassword().equals(password)/*||  !student.getEnable()*/){
            return null;
        }
        return student;
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public Student getStudentById(Long Id) {
        return studentRepository.findById(Id).orElse(null);
    }
}
