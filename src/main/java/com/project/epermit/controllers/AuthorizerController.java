package com.project.epermit.controllers;

import com.project.epermit.Model.RiderDetails;
import com.project.epermit.Model.Users;
import com.project.epermit.Service.RiderDetailsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("authorizer")
public class AuthorizerController {
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
        if (!((Users) obj).getRoleId().equals("AUTHORIZER")) {

            return "notallowed";
        }
        return "authorizer/dashboard";
    }
    @GetMapping("/verifyriderpage")
    public String verifyRiderPage(HttpServletRequest request, Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("AUTHORIZER")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        List<RiderDetails> users = riderDetailsService.fetchUnverifiedRiders(currentUser.getUsername());
        model.addAttribute("users",users);
        return "authorizer/verifyrider";
    }

    @PostMapping("/processverifyrider")
    public String processVerifyRider(HttpServletRequest request,Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("AUTHORIZER")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String adminuser = currentUser.getUsername();
        String [] arr = request.getParameter("user").split(",");
        for(int i=0;i<arr.length;i++){
            //Verify User in here
            riderDetailsService.verifyRider(arr[i],adminuser);
            //get user information in here
            //send mail in here
        }

        return "authorizer/verifyuser";
    }

    @PostMapping("/processrejectrider")
    public String rejectUser(HttpServletRequest request,Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("AUTHORIZER")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String adminuser = currentUser.getUsername();
        String [] arr = request.getParameter("user").split(",");
        for(int i=0;i<arr.length;i++){
            riderDetailsService.rejectUser(arr[i],adminuser);
        }
        return "authorizer/verifyrider";
    }
    @RequestMapping("/logout")
    public String logout(javax.servlet.http.HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
}
