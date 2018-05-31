package com.project.epermit.dao;

import com.project.epermit.Model.Centers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentersDao extends JpaRepository<Centers,Long> {
}
