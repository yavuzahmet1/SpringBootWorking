package org.example;

import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String nullName=null;
        String name=Optional.ofNullable(nullName).orElse("Ali");
        System.out.println(name);

        Person person1 = new Person("Ahmet", 19);
        Person person2 = new Person("Mehmet", 20);
        Person person3 = new Person("Ali", 25);
        Person person4 = new Person("Veli", 19);
        Optional<Person> person=Optional.of(person1);
        person.ifPresent(person5 -> System.out.println(person5.getName().length()));




    }
}