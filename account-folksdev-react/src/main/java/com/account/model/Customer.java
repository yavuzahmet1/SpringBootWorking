package com.account.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
}
