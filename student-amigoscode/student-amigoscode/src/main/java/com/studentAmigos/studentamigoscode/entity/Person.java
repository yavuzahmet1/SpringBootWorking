package com.studentAmigos.studentamigoscode.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Person {
    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
