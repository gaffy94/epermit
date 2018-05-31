package com.project.epermit.Service;

import com.project.epermit.Model.BaseResponse;
import com.project.epermit.Model.Users;
import com.project.epermit.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {
    @Autowired
    UsersDao usersDao;


    public Users createAdminUser(Users user) {
        return usersDao.save(user);
    }

    public Map<String, Object> loginUser(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        Users user = usersDao.findByUsernameAndPassword(username, password);
        if (user == null) {
            map.put("responsecode", "99");
            map.put("responsemessage", "User not found");
        } else {
            map.put("responsecode", "00");
            map.put("responsemessage", "User Found");
            map.put("userDetails", user);
        }
        return map;
    }

    public BaseResponse createUser(Users user) {
        BaseResponse resp = new BaseResponse();
        user.setPassword(user.getPassword()); //encrypt later;
        try {
            Users save = usersDao.save(user);
        } catch (Exception e) {
            resp.setResponsecode("99");
            resp.setResponsemessage(e.getLocalizedMessage());
            return resp;

        }
        resp.setResponsemessage("success");
        resp.setResponsecode("00");
        return resp;
    }

    public String fetchUserRole(String username) {
        return usersDao.findUserRoleByUsername(username);
    }

    public List<Users> fetchUnverifiedUsers(String username) {
        return usersDao.fetchUnverifiedUsers(username);
    }

    public void verifyUser( String user,String adminuser) {
        Users duser = usersDao.findByUsername(user);
        duser.setApprovedBy(adminuser);
        duser.setApproved('Y');
        String date = usersDao.getDatabaseDate();
        System.out.println("Database Date now is : " + date);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date ddate = new Date();
        try {
            ddate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        duser.setApprovedDate(ddate);
        //usersDao.verifyUser(adminuser,user);
        usersDao.save(duser);


    }

    public void rejectUser(String user, String adminuser) {
        Users duser = usersDao.findByUsername(user);
        duser.setRejectedBy(adminuser);
        duser.setRejected('Y');
        String date = usersDao.getDatabaseDate();
        System.out.println("Database Date now is : " + date);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date ddate = new Date();
        try {
            ddate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        duser.setRejectDate(ddate);
        //usersDao.verifyUser(adminuser,user);
        usersDao.save(duser);
    }

    public List<Users> fetchRejectedUsers(String username) {
        return usersDao.fetchRejectedUsers(username);
    }

    public Users findByUsername(String username) {
        return usersDao.findByUsername(username);
    }

    public void deleteByUserName(String username) {
        usersDao.deleteByUsername(username);
    }

    public Long fetchVerifiedUsers() {
        return usersDao.fetchNumberofVerifiedUsers();
    }

    public Long fetchAllRejectedUsers() {
        return usersDao.fetchAllRejectedUser();
    }

    public Long fetchAllUsers() {
        return usersDao.findNumberofAllUsers();
    }

    public Long fetchAllUnverifiedUsers() {
        return usersDao.fetchAllUnverifiedUsers();
    }
}
