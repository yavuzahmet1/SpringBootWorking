package com.account.service;

import com.account.model.Account;
import com.account.model.Transaction;
import com.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    private Logger logger = LoggerFactory.getLogger(TransactionService.class);//hata mesajının nerden üretildiğini bize bildirir
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount) {
        return transactionRepository.save(
                new Transaction(amount,account));
    }
}
