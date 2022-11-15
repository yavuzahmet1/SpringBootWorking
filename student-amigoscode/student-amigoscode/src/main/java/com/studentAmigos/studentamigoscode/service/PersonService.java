package com.studentAmigos.studentamigoscode.service;

import com.studentAmigos.studentamigoscode.entity.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    int addPerson(Person person);

    List<Person> getAllPerson();

    List<Person> getPersonById(UUID id);
}
