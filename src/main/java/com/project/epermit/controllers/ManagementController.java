package com.project.epermit.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.epermit.Model.*;
import com.project.epermit.Service.CentersService;
import com.project.epermit.Service.RiderDetailsService;
import com.project.epermit.Service.UsersService;
import com.project.epermit.Service.VehicleDetailsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("management")
public class ManagementController {
    @Autowired
    UsersService usersService;
    @Autowired
    RiderDetailsService riderDetailsService;
    @Autowired
    VehicleDetailsService vehicleDetailsService;
    @Autowired
    CentersService centersService;

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("MANAGEMENT")) {

            return "notallowed";
        }
        Long allcreatedusers = usersService.fetchAllUsers();
        model.addAttribute("allcreatedusers", allcreatedusers);
        Long verifiedusers = usersService.fetchVerifiedUsers();
        model.addAttribute("verifiedusers", verifiedusers);
        Long unverifiedusers = usersService.fetchAllUnverifiedUsers();
        model.addAttribute("unverifiedusers", unverifiedusers);
        Long rejectedusers = usersService.fetchAllRejectedUsers();
        model.addAttribute("rejectedusers", rejectedusers);
        Long allcreatedriders = riderDetailsService.fetchAllRiders();
        model.addAttribute("allcreatedriders", allcreatedriders);
        Long verifiedriders = riderDetailsService.fetchAllVerifiedRiders();
        model.addAttribute("verifiedriders", verifiedriders);
        Long unverifiedriders = riderDetailsService.fetchAllUnverifiedRiders();
        model.addAttribute("unverifiedriders", unverifiedriders);
        Long rejectedriders = riderDetailsService.fetchAllRejectedRiders();
        model.addAttribute("rejectedriders", rejectedriders);
        Long numberofkeke = vehicleDetailsService.fetchNumberOfKeke();
        model.addAttribute("numberofkeke", numberofkeke);
        Long numberofBus = vehicleDetailsService.fetchNumberofBus();
        model.addAttribute("numberofBus", numberofBus);
        Long numberofMotorcycle = vehicleDetailsService.fetchNumberofOkada();
        model.addAttribute("numberofMotorcycle", numberofMotorcycle);
//        Object centerNumberofriders = "";
//        String printedIds = "";
//        String unprintedIds = "";
//        String expiredIds = "";
        String unclaimedpayments = "";
        return "management/dashboard";
    }

    @GetMapping("/viewreports")
    public String viewReports(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("MANAGEMENT")) {
            return "notallowed";
        }
        return "management/reports";
    }

    @GetMapping("rvd")
    public @ResponseBody
    String rvd(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("MANAGEMENT")) {
            return "notallowed";
        }
        List<String> rvd = vehicleDetailsService.fetchVehicleDistribution();
        HashMap<String, Long> map = new HashMap<>();
        RegisteredVehicleDistribution dist = new RegisteredVehicleDistribution();
        for (String val : rvd) {
            Long data = vehicleDetailsService.fetchVehicleDistributionVal(val);
            map.put(val, data);
        }
        List<RVD> lrvd = new ArrayList<>();
        for (HashMap.Entry<String, Long> entry : map.entrySet()) {
            RVD rd = new RVD();
            rd.setType(entry.getKey());
            rd.setCount(entry.getValue());
            lrvd.add(rd);
        }
        dist.setRvd(lrvd);
        Gson gson = new Gson();
        Type type = new TypeToken<List<RVD>>() {
        }.getType();
        String json = gson.toJson(lrvd, type);
        return json;
    }

    @GetMapping("gender")
    public @ResponseBody
    String gender(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("MANAGEMENT")) {
            return "notallowed";
        }
        Long allRiders = Long.valueOf(riderDetailsService.findAll().size());
        List<String> gender = riderDetailsService.fetchGenderDistribution();
        HashMap<String, Double> map = new HashMap<>();
        GenderDistribution dist = new GenderDistribution();
        for (String val : gender) {
            Long data = riderDetailsService.fetchGenderDistributionVal(val);
            Double datum = Double.valueOf(data);
            datum = (datum/allRiders)*100;
            map.put(val, datum);
        }
        List<Gender> lrvd = new ArrayList<>();
        for (HashMap.Entry<String, Double> entry : map.entrySet()) {
            Gender rd = new Gender();
            rd.setLabel(entry.getKey());
            rd.setValue(entry.getValue());
            lrvd.add(rd);
        }
        dist.setGenderList(lrvd);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Gender>>() {
        }.getType();
        String json = gson.toJson(lrvd, type);
        return json;
    }

    @GetMapping("center")
    public @ResponseBody
    String center(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("MANAGEMENT")) {
            return "notallowed";
        }
        List<Centers> center = centersService.findAll();
        HashMap<String, Long> map = new HashMap<>();
        CenterList dist = new CenterList();
        for (Centers val : center) {
            Long data = riderDetailsService.fetchCenterDistributionVal(val.getId());
            map.put(val.getCenterName(), data);
        }
        List<CenterCount> lrvd = new ArrayList<>();
        for (HashMap.Entry<String, Long> entry : map.entrySet()) {
            CenterCount rd = new CenterCount();
            rd.setCenter(entry.getKey());
            rd.setCount(entry.getValue());
            lrvd.add(rd);
        }
        dist.setCenterCountListl(lrvd);
        Gson gson = new Gson();
        Type type = new TypeToken<List<CenterCount>>() {
        }.getType();
        String json = gson.toJson(lrvd, type);
        return json;
    }

    @RequestMapping("/logout")
    public String logout(javax.servlet.http.HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

}
