package com.example.Emailtest.Service;

import com.example.Emailtest.Domain.Conformation;
import com.example.Emailtest.Domain.Student;
import com.example.Emailtest.Repository.ConformationRepository;
import com.example.Emailtest.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ConformationRepository conformationRepository;
    private final EmailService emailService;

    public Student saveStudent(Student student){
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new RuntimeException("Email all reedy taken");
        }
        student.setEnable(false);
        studentRepository.save(student);
        Conformation conformation =new Conformation(student);
        conformationRepository.save(conformation);
        emailService.sendVerifyEmail(student.getEmail(), student.getName(), conformation.getToken());
    return student;
    }
    public Boolean verifyToken(String token){
        Conformation conformation=conformationRepository.findByToken(token);
        Student student=studentRepository.findByEmail(conformation.getStudent().getEmail());
        studentRepository.save(student);
        studentRepository. save(student);
        return Boolean.TRUE;
    }
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
