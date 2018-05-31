package com.project.epermit.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class RVD {
    private String type;
    private Long count;

    public RVD() {
    }


    public RVD(String type, Long count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
