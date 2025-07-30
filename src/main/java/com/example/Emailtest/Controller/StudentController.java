package com.example.Emailtest.Controller;

import java.time.LocalDateTime; // Fixed spelling
import java.util.List;
import java.util.Map;

import com.example.Emailtest.Domain.Performance;
import com.example.Emailtest.Service.PerformanceService;
import com.sun.net.httpserver.HttpsServer;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Emailtest.Domain.HttpsResponse;
import com.example.Emailtest.Domain.Student;
import com.example.Emailtest.Service.StudentService;

import lombok.RequiredArgsConstructor;

// @RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/student") // Removed trailing slash for consistency
public class StudentController {
    private final StudentService studentService;
    private final PerformanceService performanceService;

    @GetMapping
    @ResponseBody 
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PostMapping("/register")
    public String createStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/success";
    }
    @PostMapping("/login")
    public String processingLogin(@RequestParam String email , @RequestParam String password, HttpSession session, Model model){
        Student student = studentService.valaiDateLogin(email, password);
        if(student == null){
            model.addAttribute("error","Invalid credentials or email not verified.");
            model.addAttribute("student", new Student());
            return "LoginPage";
        }
        session.setAttribute("Id",student.getId());
        return "redirect:/api/student/Dashboard?Id=" + student.getId();

    }

    @GetMapping("/view")
    public String viewStudent(Model model) {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "test";
    }
    // @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // public ResponseEntity<HttpsResponse> createStudent(@ModelAttribute Student student) {
    //     Student newStudent = studentService.saveStudent(student);
    //     return ResponseEntity.created(URI.create("/api/student/" + newStudent.getId())).body(
    //             HttpsResponse.builder().timeStamp(LocalDateTime.now().toString()).data(Map.of("student", newStudent)).message("Student Created").status(HttpStatus.CREATED).statusCode(HttpStatus.CREATED.value()).build());
    // }
    @GetMapping("/Dashboard")
    public String showDashboard(@RequestParam("Id") Long Id, Model model) {
        Student student = studentService.getStudentById(Id);
        Performance performance = performanceService.getPerformanceById(Id);
        if (student == null || performance == null) {
            model.addAttribute("message", "Student or performance data not found.");
            return "errorPage"; // or handle appropriately
        }
        model.addAttribute("student", student);
        model.addAttribute("performance", performance);
        return "Dashboard";
    }


    @GetMapping("/confirm")
    public ResponseEntity<HttpsResponse> confirmStudent(@RequestParam("token") String token) {
        Boolean isSuccess = studentService.verifyToken(token);
        return ResponseEntity.ok().body(HttpsResponse.builder().timeStamp(LocalDateTime.now().toString()).data(Map.of("success", isSuccess)).message("Student Confirmed").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());
    }
}