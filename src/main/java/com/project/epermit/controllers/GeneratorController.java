package com.project.epermit.controllers;

import com.project.epermit.Model.RiderDetails;
import com.project.epermit.Model.Users;
import com.project.epermit.Service.RiderDetailsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("generator")
public class GeneratorController {
    @Autowired
    RiderDetailsService riderDetailsService;

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("GENERATOR")) {

            return "notallowed";
        }
        return "generator/dashboard";
    }
    @GetMapping("generatecard")
    public String generateCard(HttpServletRequest request, Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("GENERATOR")) {

            return "notallowed";
        }
        List<RiderDetails> rd = riderDetailsService.fetchListVerifiedRiders();
        model.addAttribute("riders",rd);
        return "generator/generatecard";
    }
    @PostMapping("/generatecard")
    public String processVerifyUser(HttpServletRequest request,Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("GENERATOR")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String adminuser = currentUser.getUsername();
        String [] arr = request.getParameter("user").split(",");
        for(int i=0;i<arr.length;i++){
            //Verify User in here
            riderDetailsService.generateCard(arr[i],adminuser);
            //get user information in here
            //send mail in here
            System.out.println("");
        }

        return "internal/verifyuser";
    }

    @RequestMapping("/logout")
    public String logout(javax.servlet.http.HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
}
