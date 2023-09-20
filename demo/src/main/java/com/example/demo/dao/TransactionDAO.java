package com.example.demo.dao;

import com.example.demo.entity.TransactionEntity;

import java.util.List;

public interface TransactionDAO {
    List<TransactionEntity> getTransactionsByName(String name);
    List<TransactionEntity> getTransactionsByNameMonth(String name, int month);
    TransactionEntity addTransaction(TransactionEntity transaction);
    void deleteTransaction(String name);
}
