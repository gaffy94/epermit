package com.project.epermit.dao;

import com.project.epermit.Model.RiderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RiderDetailsDao extends JpaRepository<RiderDetails,Long> {
    Optional<RiderDetails> findByRiderUniqueCode(@Param("userid") String userid);
    @Query(value = "SELECT * FROM RIDERS t WHERE t.VERIFICATION_STATUS = 'N' AND t.REJECTED = 'N' AND t.REGISTRATION_STATUS = 'COMPLETE' AND  t.REGISTERED_BY <> :username",nativeQuery = true)
    List<RiderDetails> fetchUnverifiedRiders(@Param("username" ) String username);
    List<RiderDetails> findAllByRejectedAndRejectedByIsNotAndAndRiderRegisteredBy(@Param("rej") char rej,@Param("username") String username,@Param("username") String crusername);
    void deleteByRiderUniqueCode(@Param("username") String username);
    @Query(value = "SELECT COUNT(*) FROM RIDERS t",nativeQuery = true)
    Long fetchAllRiders();
    @Query(value = "SELECT COUNT(*) FROM RIDERS t WHERE t.REJECTED = 'Y'",nativeQuery = true)
    Long fetchAllRejectedRiders();
    @Query(value = "SELECT COUNT(*) FROM RIDERS t WHERE t.VERIFICATION_STATUS = 'Y'",nativeQuery = true)
    Long fetchAllVerifiedRiders();
    @Query(value = "SELECT COUNT(*) FROM RIDERS t WHERE t.VERIFICATION_STATUS = 'N'",nativeQuery = true)
    Long fetchAllUnverifiedRiders();
    @Query(value = "SELECT DISTINCT GENDER FROM RIDERS",nativeQuery = true)
    List<String> fetchGenderDistribution();
    @Query(value = "SELECT  COUNT(*) AS COUNT FROM RIDERS WHERE GENDER = :val",nativeQuery = true)
    Long fetchGenderDistributionVal(@Param("val") String val);
    @Query(value = "SELECT  COUNT(*) AS COUNT FROM RIDERS WHERE REGISTRATION_CENTER_ID = :id",nativeQuery = true)
    Long fetchCenterDistributionVal(@Param("id") Long id);
    Optional<RiderDetails> findByRiderUniqueCodeAndRiderVerificationStatusIsNot(@Param("userid") String userid,@Param("status") char status);
    @Query(value = "SELECT * FROM RIDERS t WHERE t.VERIFICATION_STATUS = :status AND t.CARD_GENERATED = :cardgenstatus",nativeQuery = true)
    List<RiderDetails> findAllByCustQuery(@Param("status") char status,@Param("cardgenstatus") char cardgenstatus);
}
