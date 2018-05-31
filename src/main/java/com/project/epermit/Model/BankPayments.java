package com.project.epermit.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "PAYMENTS")
public class BankPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long paymentId;
    @Column(name = "TELLER_NUMBER", unique = true)
    private String tellerNumber;
    @NotBlank(message = "Please provide the payment Surname")
    @Column(name = "SURNAME")
    private String Surname;
    @Column(name = "STATUS")
    private String status;
    public BankPayments(){

    }
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Long getPaymentId(){
        return paymentId;
    }

    public void setPaymentId(Long paymentId){
        this.paymentId = paymentId;
    }

    public String getTellerNumber(){
        return tellerNumber;
    }

    public void setTellerNumber(String tellerNumber) {
        this.tellerNumber = tellerNumber;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
