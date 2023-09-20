package com.example.demo.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class Transaction {
    private long id;
    @NotBlank
    private String customerName;
    @Min(1)
    @Max(12)
    @NotNull
    private int transactionMonth;
    @Min(0)
    @NotNull
    private double amount;

    public Transaction() {
    }

    public Transaction(long id, String customerName, int transactionMonth, double amount) {
        this.id = id;
        this.customerName = customerName;
        this.transactionMonth = transactionMonth;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTransactionMonth() {
        return transactionMonth;
    }

    public void setTransactionMonth(int transactionMonth) {
        this.transactionMonth = transactionMonth;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
