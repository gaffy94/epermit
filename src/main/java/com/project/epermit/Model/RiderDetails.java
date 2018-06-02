package com.project.epermit.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "RIDERS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @NotNull()
    @Column(name = "UNIQUE_CODE",unique = true)
    private String riderUniqueCode;
    @Column(name = "TELLER_NUMBER")
    private String riderTellerNumber;
    @Column(name = "SURNAME")
    private String riderSurname;
    @Column(name = "FIRSTNAME")
    private String riderFirstname;
    @Column(name = "OTHERNAMES")
    private String riderOtherNames;
    @Column(name = "GENDER")
    private String riderGender;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.DATE)
    private Date riderDateOfBirth;
    @Column(name = "PHONENUMBER")
    private String riderPhonenumber;
    @Column(name = "EMAIL")
    private String riderEmail;
    @Column(name = "ADDRESS")
    private String riderAddress;
    @Column(name = "ORIGIN")
    private String riderStateOfOrigin;
    @Column(name = "LOCALGOVT")
    private String riderLocalGovt;
    @Column(name = "REGISTRATION_CENTER_ID")
    private String riderRegistrationCenter;
    @Column(name = "IMAGE_DATA")
    private String riderImageData;
    @Column(name = "VEHICLE_ID")
    private String riderVehicleId;
    @Column(name = "REGISTRATION_STATUS")
    private String riderRegistrationStatus;
    @NotNull()
    @Column(name = "REGISTERED_BY",updatable = false)
    private String riderRegisteredBy;
    @Column(name = "REGISTRATION_DATE")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date riderRegistrationDate;
    @NotNull()
    @Column(name = "MODIFIED_BY")
    private String riderModifiedBy;
    @Column(name = "MODIFICATION_DATE")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date riderModificationDate;
    @Column(name = "VERIFICATION_STATUS")
    private char riderVerificationStatus;
    @Column(name = "VERIFIED_BY")
    private String riderVerifiedby;
    @Column(name = "VERIFICATION_DATE")
    private Date riderVerificationDate;
    @Column(name = "REJECTED")
    private char rejected;
    @Column(name = "REJECTED_BY")
    private String rejectedBy;
    @Column(name = "REJECT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rejectDate;
    @Column(name = "CARD_GENERATED")
    private char GenerateCard;
    @Column(name = "CARD_GENERATED_BY")
    private String generateBy;
    @Column(name = "CARD_GENERATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date generatedDate;
    @OneToOne(targetEntity=VehicleDetails.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    @JoinColumn(name="VEHICLE_ID",referencedColumnName = "ID",insertable = false,updatable = false)
    private VehicleDetails vehicleDetails;
    @ManyToOne(targetEntity=Centers.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="REGISTRATION_CENTER_ID",referencedColumnName = "ID",insertable = false,updatable = false)
    private Centers center;
    public RiderDetails() {
    }

    public char getGenerateCard() {
        return GenerateCard;
    }

    public void setGenerateCard(char generateCard) {
        GenerateCard = generateCard;
    }

    public String getGenerateBy() {
        return generateBy;
    }

    public void setGenerateBy(String generateBy) {
        this.generateBy = generateBy;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
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

    public Centers getCenter() {
        return center;
    }

    public void setCenter(Centers center) {
        this.center = center;
    }

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRiderUniqueCode() {
        return riderUniqueCode;
    }

    public void setRiderUniqueCode(String riderUniqueCode) {
        this.riderUniqueCode = riderUniqueCode;
    }

    public String getRiderTellerNumber() {
        return riderTellerNumber;
    }

    public void setRiderTellerNumber(String riderTellerNumber) {
        this.riderTellerNumber = riderTellerNumber;
    }

    public String getRiderSurname() {
        return riderSurname;
    }

    public void setRiderSurname(String riderSurname) {
        this.riderSurname = riderSurname;
    }

    public String getRiderFirstname() {
        return riderFirstname;
    }

    public void setRiderFirstname(String riderFirstname) {
        this.riderFirstname = riderFirstname;
    }

    public String getRiderOtherNames() {
        return riderOtherNames;
    }

    public void setRiderOtherNames(String riderOtherNames) {
        this.riderOtherNames = riderOtherNames;
    }

    public String getRiderGender() {
        return riderGender;
    }

    public void setRiderGender(String riderGender) {
        this.riderGender = riderGender;
    }

    public Date getRiderDateOfBirth() {
        return riderDateOfBirth;
    }

    public void setRiderDateOfBirth(Date riderDateOfBirth) {
        this.riderDateOfBirth = riderDateOfBirth;
    }

    public String getRiderPhonenumber() {
        return riderPhonenumber;
    }

    public void setRiderPhonenumber(String riderPhonenumber) {
        this.riderPhonenumber = riderPhonenumber;
    }

    public String getRiderEmail() {
        return riderEmail;
    }

    public void setRiderEmail(String riderEmail) {
        this.riderEmail = riderEmail;
    }

    public String getRiderAddress() {
        return riderAddress;
    }

    public void setRiderAddress(String riderAddress) {
        this.riderAddress = riderAddress;
    }

    public String getRiderStateOfOrigin() {
        return riderStateOfOrigin;
    }

    public void setRiderStateOfOrigin(String riderStateOfOrigin) {
        this.riderStateOfOrigin = riderStateOfOrigin;
    }

    public String getRiderLocalGovt() {
        return riderLocalGovt;
    }

    public void setRiderLocalGovt(String riderLocalGovt) {
        this.riderLocalGovt = riderLocalGovt;
    }

    public String getRiderRegistrationCenter() {
        return riderRegistrationCenter;
    }

    public void setRiderRegistrationCenter(String riderRegistrationCenter) {
        this.riderRegistrationCenter = riderRegistrationCenter;
    }

    public String getRiderImageData() {
        return riderImageData;
    }

    public void setRiderImageData(String riderImageData) {
        this.riderImageData = riderImageData;
    }

    public String getRiderVehicleId() {
        return riderVehicleId;
    }

    public void setRiderVehicleId(String riderVehicleId) {
        this.riderVehicleId = riderVehicleId;
    }

    public String getRiderRegistrationStatus() {
        return riderRegistrationStatus;
    }

    public void setRiderRegistrationStatus(String riderRegistrationStatus) {
        this.riderRegistrationStatus = riderRegistrationStatus;
    }

    public String getRiderRegisteredBy() {
        return riderRegisteredBy;
    }

    public void setRiderRegisteredBy(String riderRegisteredBy) {
        this.riderRegisteredBy = riderRegisteredBy;
    }

    public Date getRiderRegistrationDate() {
        return riderRegistrationDate;
    }

    public void setRiderRegistrationDate(Date riderRegistrationDate) {
        this.riderRegistrationDate = riderRegistrationDate;
    }

    public String getRiderModifiedBy() {
        return riderModifiedBy;
    }

    public void setRiderModifiedBy(String riderModifiedBy) {
        this.riderModifiedBy = riderModifiedBy;
    }

    public Date getRiderModificationDate() {
        return riderModificationDate;
    }

    public void setRiderModificationDate(Date riderModificationDate) {
        this.riderModificationDate = riderModificationDate;
    }

    public char getRiderVerificationStatus() {
        return riderVerificationStatus;
    }

    public void setRiderVerificationStatus(char riderVerificationStatus) {
        this.riderVerificationStatus = riderVerificationStatus;
    }

    public String getRiderVerifiedby() {
        return riderVerifiedby;
    }

    public void setRiderVerifiedby(String riderVerifiedby) {
        this.riderVerifiedby = riderVerifiedby;
    }

    public Date getRiderVerificationDate() {
        return riderVerificationDate;
    }

    public void setRiderVerificationDate(Date riderVerificationDate) {
        this.riderVerificationDate = riderVerificationDate;
    }
}
