package com.project.epermit.controllers;

import com.project.epermit.Model.Users;
import com.project.epermit.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/loginhandler")
    public String loginHandler(Model model,HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String,Object> response = usersService.loginUser(username,password);
        if(response.get("responsecode").equals("00")){
            String role = usersService.fetchUserRole(username);
            System.out.println("The role is :" + role);
            String landingPage = "";
            switch (role){
                case "ADMIN":
                        landingPage = "admin";
                        break;
                case "INPUTTER":
                        landingPage = "inputter";
                        break;
                case "INTERNAL":
                    landingPage = "internal";
                    break;
                case "AUTHORIZER":
                    landingPage = "authorizer";
                    break;
                case "MANAGEMENT":
                    landingPage = "management";
                    break;
                case "GENERATOR":
                    landingPage="generator";
                    break;
                case "AGENTS":
                    landingPage = "agents";
                    break;
            }
            System.out.println("Landing Page " + landingPage);
            request.getSession().setAttribute("userDetails",response.get("userDetails"));
            model.addAttribute("userDetails",response.get("userDetails"));
            return "redirect:/"+landingPage+"/dashboard";
        }
        else{
            model.addAttribute("message","Log in Failed");
        }
        return "index";
    }


}
