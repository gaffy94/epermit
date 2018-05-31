package com.project.epermit.dao;

import com.project.epermit.Model.RVD;
import com.project.epermit.Model.RegisteredVehicleDistribution;
import com.project.epermit.Model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface VehicleDetailsDao extends JpaRepository<VehicleDetails,Long> {
    Optional<VehicleDetails> findByVehicleOwnerId(@Param("id") String id);
    @Query(value = "SELECT COUNT(*) FROM VEHICLES t WHERE t.TYPE = 'Keke'",nativeQuery = true)
    Long fetchNumberOfKeke();
    @Query(value = "SELECT COUNT(*) FROM VEHICLES t WHERE t.TYPE = 'Bus'",nativeQuery = true)
    Long fetchNumberOfBus();
    @Query(value = "SELECT COUNT(*) FROM VEHICLES t WHERE t.TYPE = 'Okada'",nativeQuery = true)
    Long fetchNumberOfOkada();
    @Query(value = "SELECT DISTINCT TYPE FROM VEHICLES",nativeQuery = true)
    List<String> fetchVehicleDistribution();
    @Query(value = "SELECT  COUNT(*) AS COUNT FROM VEHICLES WHERE TYPE = :type",nativeQuery = true)
    Long fetchVehicleDistributionVal(@Param("type") String type);
}
