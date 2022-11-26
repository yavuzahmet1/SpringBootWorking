package com.trial.spring.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity implements Serializable {
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;


}
/*Serializable interfacesisni implemente
ederek bizim nesnenimiz netwöke taşıma ve yazdırmayı sağlıyor*/