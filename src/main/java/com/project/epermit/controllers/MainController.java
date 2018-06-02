package com.project.epermit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
       return "index";
    }
    @GetMapping("/test")
    public @ResponseBody String testend(){
        return "hello world";
    }


}
