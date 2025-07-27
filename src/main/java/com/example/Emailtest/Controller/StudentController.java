package com.example.Emailtest.Controller;

import java.net.URI; // Fixed spelling
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Emailtest.Domain.HttpsResponse;
import com.example.Emailtest.Domain.Student;
import com.example.Emailtest.Service.StudentService;

@RestController
@RequestMapping("/api/student") // Removed trailing slash for consistency
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<HttpsResponse> createStudent(@ModelAttribute Student student) {
        Student newStudent = studentService.saveStudent(student);
        return ResponseEntity.created(URI.create("/api/student/" + newStudent.getId())).body(
                HttpsResponse.builder().timeStamp(LocalDateTime.now().toString()).data(Map.of("student", newStudent)).message("Student Created").status(HttpStatus.CREATED).statusCode(HttpStatus.CREATED.value()).build());
    }

    @GetMapping("/confirm")
    public ResponseEntity<HttpsResponse> confirmStudent(@RequestParam("token") String token) {
        Boolean isSuccess = studentService.verifyToken(token);
        return ResponseEntity.ok().body(HttpsResponse.builder().timeStamp(LocalDateTime.now().toString()).data(Map.of("success", isSuccess)).message("Student Confirmed").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());
    }
}