package com.example.demo.controller;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Reward;
import com.example.demo.model.Transaction;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/api")
public class RewardRestController {

    private CustomerService customerService;
    private TransactionService transactionService;

    @Autowired
    public RewardRestController(TransactionService transactionService, CustomerService customerService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    @GetMapping("/rewards")
    public ResponseEntity<Double> getRewards(@Validated @RequestBody Reward reward) {
        String name = reward.getCustomerName();
        int month = reward.getMonth();
        Customer customer = customerService.findByName(name);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        List<Transaction> transactionList = transactionService.getTransactionsByNameMonth(name, month);
        double totalReward = totalRewardCalculator(transactionList);
        return new ResponseEntity<>(totalReward, HttpStatus.OK);
    }

    private double totalRewardCalculator(List<Transaction> transactionList) {
        return transactionList.stream().mapToDouble(t -> singleRewardCalculator(t)).sum();
    }

    private double singleRewardCalculator(Transaction transaction) {
        double amount = transaction.getAmount();
        if (amount >= 100) {
            return 50 + 2 * (amount - 100);
        } else if (amount >= 50) {
            return amount - 50;
        } else {
            return 0;
        }
    }
}
