package com.project.epermit.Model;

public class Gender {
    private String label;
    private Double value;

    public Gender(String label, Double value) {
        this.label = label;
        this.value = value;
    }

    public Gender() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
