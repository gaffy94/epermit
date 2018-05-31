package com.project.epermit.Service;

import com.project.epermit.Model.BaseResponse;
import com.project.epermit.Model.RVD;
import com.project.epermit.Model.RegisteredVehicleDistribution;
import com.project.epermit.Model.VehicleDetails;
import com.project.epermit.dao.VehicleDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VehicleDetailsService {
    @Autowired
    VehicleDetailsDao vehicleDetailsDao;

    public BaseResponse createVeh(VehicleDetails vdetails) {
        BaseResponse resp = new BaseResponse();
        VehicleDetails save = new VehicleDetails();

        try{
            save = vehicleDetailsDao.save(vdetails);
        }
        catch(Exception e){
            e.printStackTrace();
            resp.setResponsecode("99");
            resp.setResponsemessage("There was an error saving the vehicle because : "+e.getMessage());
            return resp;
        }
        resp.setResponsecode("00");
        resp.setResponsemessage("successful");
        resp.setCreatedId(String.valueOf(save.getId()));
        return resp;
    }

    public Optional<VehicleDetails> findByRiderId(Long id) {
        return vehicleDetailsDao.findByVehicleOwnerId(String.valueOf(id));
    }

    public Long fetchNumberOfKeke() {
        return vehicleDetailsDao.fetchNumberOfKeke();
    }

    public Long fetchNumberofBus() {
        return vehicleDetailsDao.fetchNumberOfBus();
    }
    public Long fetchNumberofOkada(){
        return vehicleDetailsDao.fetchNumberOfOkada();
    }

    public List<String> fetchVehicleDistribution() {
        return  vehicleDetailsDao.fetchVehicleDistribution();
    }

    public Long fetchVehicleDistributionVal(String type) {
        return vehicleDetailsDao.fetchVehicleDistributionVal(type);
    }
}
