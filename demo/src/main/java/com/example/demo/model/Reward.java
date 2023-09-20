package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;



public class Reward {
    @NotNull
    private String customerName;
    @Min(1)
    @Max(12)
    private int month;

    public Reward(String customerName, int month) {
        this.customerName = customerName;
        this.month = month;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
