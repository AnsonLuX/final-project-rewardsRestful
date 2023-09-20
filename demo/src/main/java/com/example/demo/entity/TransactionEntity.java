package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "transaction_month")
    private int transactionMonth;
    @Column(name = "amount")
    private double amount;

    public TransactionEntity() {
    }

    public TransactionEntity(long id, String customerName, int transactionMonth, double amount) {
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

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", transactionMonth=" + transactionMonth +
                ", amount=" + amount +
                '}';
    }
}
