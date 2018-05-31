package com.project.epermit.Model;

import java.util.List;

public class GenderDistribution {
    private List<Gender> genderList;

    public GenderDistribution(List<Gender> genderList) {
        this.genderList = genderList;
    }

    public GenderDistribution() {
    }

    public List<Gender> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<Gender> genderList) {
        this.genderList = genderList;
    }
}
