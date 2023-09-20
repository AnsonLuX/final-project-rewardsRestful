package com.example.demo.dao;

import com.example.demo.entity.TransactionEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransactionDAOImpl implements TransactionDAO{
    private EntityManager entityManager;

    @Autowired
    public TransactionDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<TransactionEntity> getTransactionsByName(String name) {
        TypedQuery<TransactionEntity> theQuery = entityManager.createQuery(
                "SELECT t from TransactionEntity t WHERE t.customerName = :name", TransactionEntity.class);
        theQuery.setParameter("customerName", name);
        return theQuery.getResultList();
    }

    @Override
    public List<TransactionEntity> getTransactionsByNameMonth(String name, int month) {
        TypedQuery<TransactionEntity> theQuery = entityManager.createQuery(
                "SELECT t from TransactionEntity t WHERE t.customerName = :name and t.transactionMonth = :month",
                TransactionEntity.class);
        theQuery.setParameter("customerName", name);
        theQuery.setParameter("transactionMonth", month);
        return theQuery.getResultList();
    }

    @Override
    public TransactionEntity addTransaction(TransactionEntity transaction) {
        TransactionEntity dbTransaction = entityManager.merge(transaction);
        return dbTransaction;
    }

    @Override
    public void deleteTransaction(String name) {
        TypedQuery<TransactionEntity> theQuery = entityManager.createQuery(
                "SELECT t from TransactionEntity t WHERE t.customerName = :name", TransactionEntity.class);
        theQuery.setParameter("customerName", name);
        TransactionEntity theTransaction = theQuery.getSingleResult();
        entityManager.remove(theTransaction);
    }
}
