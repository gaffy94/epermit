package com.project.epermit.dao;

import com.project.epermit.Model.BankPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankPaymentsDao extends JpaRepository<BankPayments,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM PAYMENTS WHERE SURNAME = :surname AND TELLER_NUMBER = :tellernumber AND STATUS = 'UNUSED'")
    Optional<BankPayments> findBySurnameAndTellerNumber(@Param("surname") String surname,@Param("tellernumber") String tellernumber);
}
