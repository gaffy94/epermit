package com.project.epermit.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "VEHICLES")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "UNIQUE_ID")
    private String vehicleUniqueId;
    @NotNull
    @Column(name = "TYPE")
    private String vehicleType;
    @NotNull
    @Column(name = "MANUFACTURER_NAME")
    private String vehicleManufacturerName;
    @NotNull
    @Column(name = "MODEL")
    private String vehicleModel;
    @NotNull
    @Column(name = "CHASSIS_NUMBER")
    private String vehicleChassisNumber;
    @NotNull
    @Column(name = "ENGINE_NUMBER")
    private String vehicleEngineNumber;
    @NotNull
    @Column(name = "PLATE_NUMBER")
    private String vehiclePlateNumber;
    @NotNull
    @Column(name = "OWNER_ID")
    private String vehicleOwnerId;
    @NotNull()
    @Column(name = "REGISTERED_BY",updatable = false)
    private String vehicleRegisteredBy;
    @Column(name = "REGISTRATION_DATE")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date vehicleRegistrationDate;
    @NotNull()
    @Column(name = "MODIFIED_BY")
    private String vehicleModifiedBy;
    @Column(name = "MODIFICATION_DATE")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date vehicleModificationDate;
    @OneToOne(targetEntity = RiderDetails.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private RiderDetails riderDetails;

    public VehicleDetails() {
    }

    public String getVehicleRegisteredBy() {
        return vehicleRegisteredBy;
    }

    public void setVehicleRegisteredBy(String vehicleRegisteredBy) {
        this.vehicleRegisteredBy = vehicleRegisteredBy;
    }

    public Date getVehicleRegistrationDate() {
        return vehicleRegistrationDate;
    }

    public void setVehicleRegistrationDate(Date vehicleRegistrationDate) {
        this.vehicleRegistrationDate = vehicleRegistrationDate;
    }

    public String getVehicleModifiedBy() {
        return vehicleModifiedBy;
    }

    public void setVehicleModifiedBy(String vehicleModifiedBy) {
        this.vehicleModifiedBy = vehicleModifiedBy;
    }

    public Date getVehicleModificationDate() {
        return vehicleModificationDate;
    }

    public void setVehicleModificationDate(Date vehicleModificationDate) {
        this.vehicleModificationDate = vehicleModificationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleUniqueId() {
        return vehicleUniqueId;
    }

    public void setVehicleUniqueId(String vehicleUniqueId) {
        this.vehicleUniqueId = vehicleUniqueId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleManufacturerName() {
        return vehicleManufacturerName;
    }

    public void setVehicleManufacturerName(String vehicleManufacturerName) {
        this.vehicleManufacturerName = vehicleManufacturerName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleChassisNumber() {
        return vehicleChassisNumber;
    }

    public void setVehicleChassisNumber(String vehicleChassisNumber) {
        this.vehicleChassisNumber = vehicleChassisNumber;
    }

    public String getVehicleEngineNumber() {
        return vehicleEngineNumber;
    }

    public void setVehicleEngineNumber(String vehicleEngineNumber) {
        this.vehicleEngineNumber = vehicleEngineNumber;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(String vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    public RiderDetails getRiderDetails() {
        return riderDetails;
    }

    public void setRiderDetails(RiderDetails riderDetails) {
        this.riderDetails = riderDetails;
    }
}
