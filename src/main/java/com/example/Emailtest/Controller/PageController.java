package com.example.Emailtest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Emailtest.Domain.Student;
;



@Controller
public class PageController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/SigninPage")
    public String loginPage(Model model){
        model.addAttribute("student", new Student());
        return "SigninPage";
    }
    @GetMapping("/login")
    public String LoginPage(Model model) {
        model.addAttribute("student",new Student());
        return "LoginPage";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(@RequestParam String email, Model model) {
        model.addAttribute("email", email);
        return "dashboard";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
    
}
