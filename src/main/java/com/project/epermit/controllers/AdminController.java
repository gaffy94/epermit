package com.project.epermit.controllers;

import com.project.epermit.Model.BaseResponse;
import com.project.epermit.Model.Centers;
import com.project.epermit.Model.Users;
import com.project.epermit.Service.CentersService;
import com.project.epermit.Service.UsersService;
import com.project.epermit.utilities.Utilities;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UsersService usersService;
    @Autowired
    CentersService centersService;
    @Autowired
    Utilities utilities;

    @GetMapping("/createuserpage")
    public String createUserPage(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("ADMIN")) {

            return "notallowed";
        }
        List<Centers> center =centersService.findAll();
        model.addAttribute("centers",center);
        return "admin/createuser";
    }
    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("ADMIN")) {

            return "notallowed";
        }
        return "admin/dashboard";
    }

    @PostMapping("/createuser")
    public String processCreateUser(Model model, javax.servlet.http.HttpServletRequest request) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("ADMIN")) {

            return "notallowed";
        }
        String id = request.getParameter("id");
        String surname = request.getParameter("surname");
        String fname = request.getParameter("fname");
        String username = request.getParameter("username");
        String password = utilities.generatePassword();
        String role = request.getParameter("role");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String creator = currentUser.getUsername();
        String lastModifiedBy = creator;
        String centerId = request.getParameter("center");

        Users newUser = new Users();
        String ids = (id != null && id != "") ? id : null;
        if(ids !=null) {
            newUser.setId(Long.valueOf(ids));
        }
        newUser.setPassword(password);
        newUser.setApproved('N');
        newUser.setCreator(creator);
        newUser.setEmail(email);
        newUser.setLastModifiedBy(lastModifiedBy);
        newUser.setSurname(surname);
        newUser.setFname(fname);
        newUser.setPhonenumber(phonenumber);
        newUser.setRoleId(role);
        newUser.setUsername(username);
        newUser.setRejected('N');
        newUser.setCenterId(centerId);
        BaseResponse resp = new BaseResponse();
        try {
           resp = usersService.createUser(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "User was not created because : " + e.getMessage());
            model.addAttribute("messageclass","alert alert-danger");
            List<Centers> center =centersService.findAll();
            model.addAttribute("centers",center);
        }
        if (resp.getResponsecode().equals("00")) {
            model.addAttribute("message", "User was created successfull");
            model.addAttribute("messageclass","alert alert-success");
            List<Centers> center =centersService.findAll();
            model.addAttribute("centers",center);
        } else {
            model.addAttribute("message", "User was not created successfully because : " +resp.getResponsemessage());
            model.addAttribute("messageclass","alert alert-danger");
            List<Centers> center =centersService.findAll();
            model.addAttribute("centers",center);
        }
        return "admin/createuser";
    }

    @GetMapping("/rejectspage")
    public String rejectsPage(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("ADMIN")) {

            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        List<Users> users = usersService.fetchRejectedUsers(currentUser.getUsername());
        System.out.println("user size " + users.size());
        model.addAttribute("users", users);
        return "admin/rejects";
    }

    @PostMapping("/processedituser")
    public String processEditUser(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("ADMIN")) {

            return "notallowed";
        }
        //fetch username
        String username = request.getParameter("username");
        //fetch user data
        Users user = usersService.findByUsername(username);
        //populate form
        System.out.println("user info :" + user.getUsername());
        model.addAttribute("user", user);
        //return to page
        return "admin/createuser";
    }

    @PostMapping("/processdeleteuser")
    public String processDeleteUser(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("ADMIN")) {

            return "notallowed";
        }
        //delete user
        String username = request.getParameter("user");
        usersService.deleteByUserName(username);

        return "admin/rejects";
    }
    @RequestMapping("/logout")
    public String logout(javax.servlet.http.HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }


}
