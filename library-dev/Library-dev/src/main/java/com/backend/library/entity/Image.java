package com.backend.library.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Getter
@SuperBuilder
@NoArgsConstructor
public class Image extends BaseEntity{
    private String imageUrl;
}
