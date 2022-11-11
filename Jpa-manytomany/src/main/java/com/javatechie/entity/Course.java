package com.javatechie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;
    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> students;

}
