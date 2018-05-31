package com.project.epermit.controllers;

import com.project.epermit.Model.Users;
import com.project.epermit.Service.UsersService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("internal")
public class InternalController {
    @Autowired
    UsersService usersService;

    @GetMapping("/verifyuserpage")
    public String verifyUserPage(HttpServletRequest request, Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("INTERNAL")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        List<Users> users = usersService.fetchUnverifiedUsers(currentUser.getUsername());
        model.addAttribute("users",users);
        return "internal/verifyuser";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INTERNAL")) {

            return "notallowed";
        }
        return "internal/dashboard";
    }
    @PostMapping("/processverifyuser")
    public String processVerifyUser(HttpServletRequest request,Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("INTERNAL")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String adminuser = currentUser.getUsername();
        String [] arr = request.getParameter("user").split(",");
        for(int i=0;i<arr.length;i++){
            //Verify User in here
            usersService.verifyUser(arr[i],adminuser);
            //get user information in here
            //send mail in here
            System.out.println("");
        }

        return "internal/verifyuser";
    }

    @PostMapping("processrejectuser")
    public String rejectUser(HttpServletRequest request,Model model){
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if(obj==null){
            return "index";
        }
        //role check
        if(!((Users) obj).getRoleId().equals("INTERNAL")){

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String adminuser = currentUser.getUsername();
        String [] arr = request.getParameter("user").split(",");
        for(int i=0;i<arr.length;i++){
            usersService.rejectUser(arr[i],adminuser);
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
