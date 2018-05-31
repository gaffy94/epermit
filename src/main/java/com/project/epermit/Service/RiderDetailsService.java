package com.project.epermit.Service;

import com.project.epermit.Model.BaseResponse;
import com.project.epermit.Model.RiderDetails;
import com.project.epermit.Model.Users;
import com.project.epermit.dao.RiderDetailsDao;
import com.project.epermit.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RiderDetailsService {
    @Autowired
    RiderDetailsDao riderDetailsDao;
    @Autowired
    UsersDao usersDao;

    public void verifyRider(String user, String adminuser) {
        Optional<RiderDetails> duser = riderDetailsDao.findByRiderUniqueCode(user);
        duser.get().setRiderVerifiedby(adminuser);
        duser.get().setRiderVerificationStatus('Y');
        String date = usersDao.getDatabaseDate();
        System.out.println("Database Date now is : " + date);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date ddate = new Date();
        try {
            ddate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        duser.get().setRiderVerificationDate(ddate);
        //usersDao.verifyUser(adminuser,user);
        riderDetailsDao.save(duser.get());
    }

    public BaseResponse save(RiderDetails user) {
        BaseResponse resp = new BaseResponse();
        RiderDetails save = new RiderDetails();

        try{
             save = riderDetailsDao.save(user);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setResponsecode("99");
            resp.setResponsemessage("There was an error because : "+e.getMessage());
            return resp;
        }
        resp.setResponsecode("00");
        resp.setResponsemessage("successful");
        resp.setCreatedId(String.valueOf(save.getId()));
        return resp;
    }

    public Optional<RiderDetails> findById(Long aLong) {
        return riderDetailsDao.findById(aLong);
    }

    public String createUser(RiderDetails riderDetails) {
        RiderDetails save = new RiderDetails();
        try{
            save = riderDetailsDao.save(riderDetails);
        }
        catch(Exception e){
            e.printStackTrace();
            return "00";
        }
        return "00";
    }

    public Optional<RiderDetails> findByUniqueId(String userid) {
        return riderDetailsDao.findByRiderUniqueCode(userid);
    }

    public List<RiderDetails> fetchUnverifiedRiders(String username) {
        return riderDetailsDao.fetchUnverifiedRiders(username);

    }

    public void rejectUser(String user, String adminuser) {
        Optional<RiderDetails> duser = riderDetailsDao.findByRiderUniqueCode(user);
        System.out.println("Unique Code is : "+duser.get().getRiderUniqueCode());
        duser.get().setRejectedBy(adminuser);
        duser.get().setRejected('Y');
        String date = usersDao.getDatabaseDate();
        System.out.println("Database Date now is : " + date);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date ddate = new Date();
        try {
            ddate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        duser.get().setRejectDate(ddate);
        //usersDao.verifyUser(adminuser,user);
        riderDetailsDao.save(duser.get());
    }

    public List<RiderDetails> fetchRejectedUsers(String username) {
        return riderDetailsDao.findAllByRejectedAndRejectedByIsNotAndAndRiderRegisteredBy('Y',username,username);
    }

    public void deleteByUserName(String username) {
       riderDetailsDao.deleteByRiderUniqueCode(username);
    }

    public Optional<RiderDetails> findByUsername(String username) {
        return riderDetailsDao.findByRiderUniqueCode(username);
    }

    public Long fetchAllRiders() {
        return riderDetailsDao.fetchAllRiders();
    }

    public Long fetchAllRejectedRiders() {
        return riderDetailsDao.fetchAllRejectedRiders();
    }

    public Long fetchAllVerifiedRiders() {
        return riderDetailsDao.fetchAllVerifiedRiders();
    }

    public Long fetchAllUnverifiedRiders() {
        return riderDetailsDao.fetchAllUnverifiedRiders();
    }

    public List<String> fetchGenderDistribution() {
        return riderDetailsDao.fetchGenderDistribution();
    }

    public Long fetchGenderDistributionVal(String val) {
        return  riderDetailsDao.fetchGenderDistributionVal(val);
    }

    public Long fetchCenterDistributionVal(Long id) {
        return riderDetailsDao.fetchCenterDistributionVal(id);
    }

    public List<RiderDetails> findAll() {
        return riderDetailsDao.findAll();
    }
}
