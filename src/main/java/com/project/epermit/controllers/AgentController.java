package com.project.epermit.controllers;

import com.project.epermit.Model.RiderDetails;
import com.project.epermit.Model.Users;
import com.project.epermit.Service.RiderDetailsService;
import com.project.epermit.Service.VehicleDetailsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    RiderDetailsService riderDetailsService;
    @Autowired
    VehicleDetailsService vehicleDetailsService;
    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("AGENTS")) {

            return "notallowed";
        }
        return "agents/dashboard";
    }

    @PostMapping("/verify")
    public String verify(HttpServletRequest request, Model model) {
            String riderid = request.getParameter("riderid");
            String vehicleid = request.getParameter("vehicleid");
        Optional<RiderDetails> rd = riderDetailsService.findByUniqueIdVerified(riderid);
        if(!rd.isPresent()){
            model.addAttribute("message","Rider ID doesnt exist");
            model.addAttribute("messageclass","alert alert-danger");
            model.addAttribute("isexists","false");

            return "agents/dashboard";
        }

        if(!rd.get().getVehicleDetails().getVehicleUniqueId().equals(vehicleid)){
            model.addAttribute("message","Vehicle ID provided doesnt match the registered ID");
            model.addAttribute("messageclass","alert alert-danger");
            model.addAttribute("isexists","false");
            return "agents/dashboard";
        }
        model.addAttribute("message","Rider Details Found");
        model.addAttribute("messageclass","alert alert-success");
        model.addAttribute("isexists","true");
        model.addAttribute("riderdetails",rd.get());
        return "agents/dashboard";
    }

    @RequestMapping("/logout")
    public String logout(javax.servlet.http.HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }
}
