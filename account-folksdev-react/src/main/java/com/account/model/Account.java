package com.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data

public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";
    private BigDecimal balance = BigDecimal.ZERO;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account",
            fetch = FetchType.LAZY)
    private Set<Transaction> transaction;

    public Account(Customer customer, BigDecimal balance, LocalDateTime creationDate) {
        this.id = "";
        this.customer = customer;
        this.balance = balance;
        this.creationDate = creationDate;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return getId().equals(account.getId())
                && getBalance().equals(account.getBalance())
                && getCreationDate().equals(account.getCreationDate())
                && getCustomer().equals(account.getCustomer())
                && getTransaction().equals(account.getTransaction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getCreationDate(), getCustomer());
    }


}
