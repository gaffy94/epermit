package com.project.epermit.controllers;

import com.project.epermit.Model.*;
import com.project.epermit.Service.BankPaymentsService;
import com.project.epermit.Service.RiderDetailsService;
import com.project.epermit.Service.VehicleDetailsService;
import com.project.epermit.utilities.Utilities;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inputter")
public class InputterController {

    @Autowired
    BankPaymentsService bankPaymentsService;
    @Autowired
    RiderDetailsService riderDetailsService;
    @Autowired
    VehicleDetailsService vehicleDetailsService;
    @Autowired
    Utilities utilities;

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        return "inputter/dashboard";
    }

    @GetMapping("createriderdetailspage")
    public String createRiderDetailsPage(Model model, javax.servlet.http.HttpServletRequest request) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        return "inputter/createriderver";
    }

    @PostMapping("/confirmpayment")
    public String confirmPayment(Model model, javax.servlet.http.HttpServletRequest request) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        String surname = request.getParameter("surname");
        String tellernumber = request.getParameter("tellernumber");
        Optional<BankPayments> pay = bankPaymentsService.findBySurnameAndTellernumber(surname, tellernumber);
        if (!pay.isPresent()) {
            model.addAttribute("message", "Payment details not found");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/createriderver";
        }

        String uniqueid = utilities.generateUniqueUserId();
        RiderDetails user = new RiderDetails();
        user.setRiderUniqueCode(uniqueid);
        user.setRiderTellerNumber(tellernumber);
        user.setRiderRegisteredBy((String) ((Users) obj).getUsername());
        user.setRiderRegistrationCenter((String) ((Users) obj).getCenterId());
        user.setRiderModifiedBy((String) ((Users) obj).getUsername());
        user.setRiderRegistrationStatus("RIDER LEVEL");
        user.setRiderVerificationStatus('N');
        user.setRejected('N');
        BaseResponse resp = riderDetailsService.save(user);
        if (!resp.getResponsecode().equals("00")) {
            model.addAttribute("message", "An error occured because : " + resp.getResponsemessage());
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/createriderver";
        }
        model.addAttribute("id", resp.getCreatedId());
        model.addAttribute("uniqueid", uniqueid);
        bankPaymentsService.updatePaymentRow(pay.get());
        return "inputter/createrider";
    }

    @PostMapping("/createriderdetails")
    public String processCreateRider(Model model, javax.servlet.http.HttpServletRequest request) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        String id = request.getParameter("id");
        Optional<RiderDetails> rdetails = riderDetailsService.findById(Long.valueOf(id));
        String fname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String lga = request.getParameter("lga");
        String imagedate = request.getParameter("image");
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String creator = currentUser.getUsername();
        String lastModifiedBy = creator;
        rdetails.get().setRiderModifiedBy(creator);
        rdetails.get().setRiderAddress(address);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date ddate = new Date();
        try {
            ddate = formatter.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rdetails.get().setRiderDateOfBirth(ddate);
        rdetails.get().setRiderEmail(email);
        rdetails.get().setRiderFirstname(fname);
        rdetails.get().setRiderGender(gender);
        rdetails.get().setRiderImageData(imagedate);
        rdetails.get().setRiderLocalGovt(lga);
        rdetails.get().setRiderOtherNames(middlename);
        rdetails.get().setRiderPhonenumber(phonenumber);
        rdetails.get().setRiderRegistrationStatus("VEHICLE LEVEL");
        rdetails.get().setRiderStateOfOrigin(state);
        rdetails.get().setRiderSurname(surname);
        String resp = "";
        try {
            resp = riderDetailsService.createUser(rdetails.get());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "There was a fatal error while trying to save this user. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/createriderver";
        }
        if (resp.equals("00")) {
            model.addAttribute("id", id);
            model.addAttribute("rideruniqueid", rdetails.get().getRiderUniqueCode());
        } else {
            model.addAttribute("message", "User was not created successfully. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/createriderver";
        }
        return "inputter/createridervehicle";
    }

    @PostMapping("/createridervehicle")
    private String createRiderVehicle(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        String rideruniquecode = request.getParameter("rideruniquecode");
        String userid = request.getParameter("id");

        String vehtype = request.getParameter("vehtype");
        String platenumber = request.getParameter("platenumber");
        String enginenumber = request.getParameter("enginenumber");
        String chassis = request.getParameter("chassis");
        String manname = request.getParameter("manname");
        String vehmodel = request.getParameter("model");
        String uniqueid = utilities.generateUniqueVehId();
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String creator = currentUser.getUsername();
        String modifiedBy = creator;
        VehicleDetails vdetails = new VehicleDetails();
        vdetails.setVehicleChassisNumber(chassis);
        vdetails.setVehicleEngineNumber(enginenumber);
        vdetails.setVehicleManufacturerName(manname);
        vdetails.setVehicleModel(vehmodel);
        vdetails.setVehicleOwnerId(userid);
        vdetails.setVehiclePlateNumber(platenumber);
        vdetails.setVehicleType(vehtype);
        vdetails.setVehicleUniqueId(uniqueid);
        vdetails.setVehicleRegisteredBy(creator);
        vdetails.setVehicleModifiedBy(creator);
        Optional<RiderDetails> rdetails = riderDetailsService.findById(Long.valueOf(userid));
        BaseResponse resp = new BaseResponse();
        try {
            resp = vehicleDetailsService.createVeh(vdetails);
            rdetails.get().setRiderRegistrationStatus("COMPLETE");
            rdetails.get().setRiderVehicleId(resp.getCreatedId());
            riderDetailsService.save(rdetails.get());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "There was a fatal error while trying to save this vehicle. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/createriderver";
        }
        if (resp.getResponsecode().equals("00")) {
            model.addAttribute("vehicleuniquecode", uniqueid);
            model.addAttribute("rideruniquecode", rideruniquecode);
        } else {
            model.addAttribute("message", "Vehicle was not created successfully. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/createriderver";
        }
        return "inputter/registrationcomplete";
    }

    @GetMapping("/continueregistration")
    public String continueRegistraionPage(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        return "inputter/continuereg";
    }

    @PostMapping("/continuereg")
    public String continueReg(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        String userid = request.getParameter("uniqueid");
        Optional<RiderDetails> rdeet = riderDetailsService.findByUniqueId(userid);
        String status = rdeet.get().getRiderRegistrationStatus();
        System.out.println(status);
        switch (status) {
            case "RIDER LEVEL":
                model.addAttribute("id", rdeet.get().getId());
                model.addAttribute("uniqueid", userid);
                return "inputter/createrider";
            case "VEHICLE LEVEL":
                model.addAttribute("id", rdeet.get().getId());
                model.addAttribute("rideruniqueid", rdeet.get().getRiderUniqueCode());
                return "inputter/createridervehicle";
            case "COMPLETE":
                Optional<VehicleDetails> vdeet = vehicleDetailsService.findByRiderId(rdeet.get().getId());
                model.addAttribute("vehicleuniquecode", vdeet.get().getVehicleUniqueId());
                model.addAttribute("rideruniquecode", rdeet.get().getRiderUniqueCode());
                return "inputter/registrationcomplete";

        }
        return "inputter/continuereg";
    }
    @GetMapping("/rejectspage")
    public String rejectsPage(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {
            return "notallowed";
        }
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        List<RiderDetails> users = riderDetailsService.fetchRejectedUsers(currentUser.getUsername());
        System.out.println("user size " + users.size());
        model.addAttribute("users", users);
        return "inputter/rejects";
    }
    @PostMapping("/processdeleteuser")
    public String processDeleteUser(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        //delete user
        String username = request.getParameter("user");
        System.out.println("username is " + username);
        riderDetailsService.deleteByUserName(username);

        return "inputter/rejects";
    }


    @PostMapping("/processeditrider")
    public String processEditUser(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        //fetch username
        String username = request.getParameter("user");
        System.out.println("username is " + username);
        //fetch user data
        Optional<RiderDetails> user = riderDetailsService.findByUsername(username);
        //populate form
        System.out.println("user info :" + user.get().getRiderUniqueCode());
//        String dob = String.valueOf(user.get().getRiderDateOfBirth());
//        System.out.println("dob is "+dob);
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date ddate = new Date();
//        try {
//           String strDdate = formatter.format(user.get().getRiderDateOfBirth());
//            ddate = formatter.parse(strDdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        user.get().setRiderDateOfBirth(user.get().getRiderDateOfBirth());
        model.addAttribute("user", user.get());
        //return to page
        return "inputter/createrideredit";
    }

    @PostMapping("/updateriderdetails")
    public String processUpdateRider(Model model, javax.servlet.http.HttpServletRequest request) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }
        String id = request.getParameter("id");
        Optional<RiderDetails> rdetails = riderDetailsService.findById(Long.valueOf(id));
        String fname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String surname = request.getParameter("surname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String lga = request.getParameter("lga");
        String imagedate = request.getParameter("image");
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String creator = currentUser.getUsername();
        String lastModifiedBy = creator;
        rdetails.get().setRiderModifiedBy(creator);
        rdetails.get().setRiderAddress(address);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date ddate = new Date();
        try {
            ddate = formatter.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rdetails.get().setRiderDateOfBirth(ddate);
        rdetails.get().setRiderEmail(email);
        rdetails.get().setRiderFirstname(fname);
        rdetails.get().setRiderGender(gender);
        rdetails.get().setRiderImageData(imagedate);
        rdetails.get().setRiderLocalGovt(lga);
        rdetails.get().setRiderOtherNames(middlename);
        rdetails.get().setRiderPhonenumber(phonenumber);
        rdetails.get().setRiderRegistrationStatus("VEHICLE LEVEL");
        rdetails.get().setRiderStateOfOrigin(state);
        rdetails.get().setRiderSurname(surname);
        String resp = "";
        try {
            resp = riderDetailsService.createUser(rdetails.get());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "There was a fatal error while trying to re-save this user. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/continuereg";
        }
        if (resp.equals("00")) {
            model.addAttribute("id", id);
            model.addAttribute("rideruniqueid", rdetails.get().getRiderUniqueCode());
            Optional<VehicleDetails> veh = vehicleDetailsService.findByRiderId(Long.valueOf(id));
            model.addAttribute("veh",veh.get());
        } else {
            model.addAttribute("message", "User was not created successfully. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/continuereg";
        }
        return "inputter/createridervehicleedit";
    }

    @PostMapping("/updateridervehicle")
    private String updateRiderVehicle(HttpServletRequest request, Model model) {
        //null session check
        Object obj = (Users) request.getSession().getAttribute("userDetails");
        if (obj == null) {
            return "index";
        }
        //role check
        if (!((Users) obj).getRoleId().equals("INPUTTER")) {

            return "notallowed";
        }

        String rideruniquecode = request.getParameter("rideruniquecode");
        String userid = request.getParameter("id");
        String vehtype = request.getParameter("vehtype");
        String platenumber = request.getParameter("platenumber");
        String enginenumber = request.getParameter("enginenumber");
        String chassis = request.getParameter("chassis");
        String manname = request.getParameter("manname");
        String vehmodel = request.getParameter("model");
        String uniqueid = request.getParameter("vehuniqueid");
        Users currentUser = (Users) request.getSession().getAttribute("userDetails");
        String creator = currentUser.getUsername();
        String modifiedBy = creator;
        Optional<VehicleDetails> vdetails = vehicleDetailsService.findByRiderId(Long.valueOf(userid));
//        VehicleDetails vdetails = new VehicleDetails();
        vdetails.get().setId(Long.valueOf(uniqueid));
        vdetails.get().setVehicleChassisNumber(chassis);
        vdetails.get().setVehicleEngineNumber(enginenumber);
        vdetails.get().setVehicleManufacturerName(manname);
        vdetails.get().setVehicleModel(vehmodel);
        vdetails.get().setVehicleOwnerId(userid);
        vdetails.get().setVehiclePlateNumber(platenumber);
        vdetails.get().setVehicleType(vehtype);
        vdetails.get().setVehicleUniqueId(vdetails.get().getVehicleUniqueId());
        vdetails.get().setVehicleRegisteredBy(vdetails.get().getVehicleRegisteredBy());
        vdetails.get().setVehicleModifiedBy(creator);
        Optional<RiderDetails> rdetails = riderDetailsService.findById(Long.valueOf(userid));
        BaseResponse resp = new BaseResponse();
        try {
            resp = vehicleDetailsService.createVeh(vdetails.get());
            rdetails.get().setRiderRegistrationStatus("COMPLETE");
            rdetails.get().setRejected('N');
            rdetails.get().setRejectedBy(null);
            rdetails.get().setRejectDate(null);
            rdetails.get().setRiderVehicleId(resp.getCreatedId());
            riderDetailsService.save(rdetails.get());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "There was a fatal error while trying to re-save this vehicle. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/continuereg";
        }
        if (resp.getResponsecode().equals("00")) {
            model.addAttribute("vehicleuniquecode", vdetails.get().getVehicleUniqueId());
            model.addAttribute("rideruniquecode", rideruniquecode);
        } else {
            model.addAttribute("message", "Vehicle was not re-created successfully. Please resume registration using the unique code");
            model.addAttribute("messageclass", "alert alert-danger");
            return "inputter/continuereg";
        }
        return "inputter/registrationcomplete";
    }

    @RequestMapping("/logout")
    public String logout(javax.servlet.http.HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
}
