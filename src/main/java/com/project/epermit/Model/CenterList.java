package com.project.epermit.Model;

import java.util.List;

public class CenterList {
    private List<CenterCount> centerCountListl;

    public CenterList(List<CenterCount> centerCountListl) {
        this.centerCountListl = centerCountListl;
    }

    public CenterList() {
    }

    public List<CenterCount> getCenterCountListl() {
        return centerCountListl;
    }

    public void setCenterCountListl(List<CenterCount> centerCountListl) {
        this.centerCountListl = centerCountListl;
    }
}
