package com.project.epermit.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="USERS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @NotNull(message = "Please Provide Username")
    @Column(name = "USERNAME",unique = true)
    private String username;
    @NotNull(message = "Please Provide Name")
    @Column(name = "SURNAME")
    private String surname;
    @NotNull(message = "Please Provide Name")
    @Column(name = "FIRSTNAME")
    private String fname;
    @Email
    @NotNull(message = "Please Provide a Valid Email")
    @Column(name = "EMAIL")
    private String email;
    @NotNull(message = "Please Provide a Role")
    @Column(name = "ROLE")
    private String roleId;
    @NotNull(message = "Please Provide a Valid Phone Number")
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @NotNull(message = "Please supply a password")
    @Column(name = "PASSWORD")
    private String password;
    @NotBlank(message = "Please Supply Creator Name")
    @Column(name = "CREATOR",nullable = false, updatable = false)
    private String creator;
    @Column(name = "CREATION_DATE",nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date creationDate;
    @Column(name = "LAST_MODIFIED_BY")
    private String LastModifiedBy;
    @Column(name = "LAST_MODIFIED_DATE",nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date lastModifiedDate;
    @Column(name = "APPROVED")
    private char approved;
    @Column(name = "APPROVED_BY")
    private String approvedBy;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "REJECTED")
    private char rejected;
    @Column(name = "REJECTED_BY")
    private String rejectedBy;
    @Column(name = "REJECT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejectDate;
    @Column(name = "CENTER")
    private String centerId;
    @ManyToOne(targetEntity=Centers.class, fetch=FetchType.EAGER)
    @JoinColumn(name="CENTER",referencedColumnName = "ID",insertable = false,updatable = false)
    private Centers center;
    public Users() {
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public Centers getCenter() {
        return center;
    }

    public void setCenter(Centers center) {
        this.center = center;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public char getRejected() {
        return rejected;
    }

    public void setRejected(char rejected) {
        this.rejected = rejected;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public Date getRejectDate() {
        return rejectDate;
    }

    public void setRejectDate(Date rejectDate) {
        this.rejectDate = rejectDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModifiedBy() {
        return LastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        LastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public char getApproved() {
        return approved;
    }

    public void setApproved(char approved) {
        this.approved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }
}
