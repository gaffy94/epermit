package com.project.epermit.Model;

public class CenterCount {
    private String center;
    private Long count;

    public CenterCount(String center, Long count) {
        this.center = center;
        this.count = count;
    }

    public CenterCount() {
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
