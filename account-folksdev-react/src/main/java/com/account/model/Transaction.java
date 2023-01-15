package com.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction(BigDecimal amount, Account account) {
        this.id = null;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.transactionType = TransactionType.INITIAL;
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return getId()
                .equals(that.getId())
                && getTransactionType() == that.getTransactionType()
                && getAmount().equals(that.getAmount())
                && getTransactionDate().equals(that.getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTransactionType(), getAmount(), getTransactionDate(), getAccount());
    }
}
