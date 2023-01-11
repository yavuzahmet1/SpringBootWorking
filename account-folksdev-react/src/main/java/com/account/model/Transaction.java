package com.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "accound_id", nullable = false)
    private Account account;
}
