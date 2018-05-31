package com.project.epermit.Model;

import javax.persistence.*;

@Entity
public class Centers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CENTER_NAME",unique = true)
    private String centerName;
    @Column(name = "CENTER_LOCATION",unique = true)
    private String centerLocation;

    public Centers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;
    }
}
