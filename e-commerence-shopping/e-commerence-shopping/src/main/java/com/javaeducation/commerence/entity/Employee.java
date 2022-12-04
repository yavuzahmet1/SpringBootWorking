package com.javaeducation.commerence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="email")
    private String email;
}
