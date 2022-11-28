package com.example.yvzbytes.tutorial.repository;

import com.example.yvzbytes.tutorial.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
