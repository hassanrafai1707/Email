package com.example.Emailtest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PageController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/SigninPage")
    public String loginPage() {
        return "SigninPage";
    }
    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
    
}
