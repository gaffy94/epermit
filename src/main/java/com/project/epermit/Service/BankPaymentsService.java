package com.project.epermit.Service;

import com.project.epermit.Model.BankPayments;
import com.project.epermit.dao.BankPaymentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankPaymentsService {
@Autowired
    BankPaymentsDao bankPaymentsDao;

    public Optional<BankPayments> findBySurnameAndTellernumber(String surname, String tellernumber) {
        return bankPaymentsDao.findBySurnameAndTellerNumber(surname,tellernumber);
    }

    public void updatePaymentRow(BankPayments bankPayments) {
        bankPayments.setStatus("USED");
        bankPaymentsDao.save(bankPayments);
    }
}

