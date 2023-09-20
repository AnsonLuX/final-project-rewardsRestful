package com.example.demo.service;

import com.example.demo.dao.TransactionDAO;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.model.Transaction;
import com.example.demo.util.EntityVoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService{
    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public List<Transaction> getTransactionsByName(String name) {
        return EntityVoConverter.ConvertTransactionEntityToTransaction(transactionDAO.getTransactionsByName(name));
    }

    @Override
    public List<Transaction> getTransactionsByNameMonth(String name, int month) {
        return EntityVoConverter.ConvertTransactionEntityToTransaction(
                transactionDAO.getTransactionsByNameMonth(name, month));
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        TransactionEntity transactionEntity =
                transactionDAO.addTransaction(EntityVoConverter.convertVoToEntity(transaction));
        return EntityVoConverter.convertEntityToVo(transactionEntity);
    }
}
