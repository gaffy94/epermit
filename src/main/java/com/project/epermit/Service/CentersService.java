package com.project.epermit.Service;

import com.project.epermit.Model.Centers;
import com.project.epermit.dao.CentersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentersService {
    @Autowired
    CentersDao centersDao;

    public List<Centers> findAll() {
        return centersDao.findAll();
    }
}
