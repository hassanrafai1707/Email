package com.example.Emailtest.Controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import static java.lang.foreign.FunctionDescriptor.of;

@Controller
@RequiredArgsConstructor
public class CustomErrorController{
    private final ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public String handleError(WebRequest request, Model model){

        var attributes = errorAttributes.getErrorAttributes(
                request,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS)
        );
        model.addAttribute("timestamp", attributes.get("timestamp"));
        model.addAttribute("status", attributes.get("status"));
        model.addAttribute("error", attributes.get("error"));
        model.addAttribute("message", attributes.get("message"));
        model.addAttribute("path", attributes.get("path"));
        return "errorPage";
    }
}
