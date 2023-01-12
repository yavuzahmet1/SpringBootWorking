package com.account.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private Set<Account> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getId().equals(customer.getId()) && getName().equals(customer.getName()) && getLastName().equals(customer.getLastName()) && getAccounts().equals(customer.getAccounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName());
    }
}
