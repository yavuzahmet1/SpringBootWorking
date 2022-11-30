package com.backend.library.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class User extends BaseEntity {
}
