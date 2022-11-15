package org.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person person1 = new Person("Ahmet", 19);
        Person person2 = new Person("Mehmet", 20);
        Person person3 = new Person("Ali", 25);
        Person person4 = new Person("Veli", 19);

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        for (Person p : persons) {
            System.out.println(p.getName());

        }
        persons.stream().forEach(person -> System.out.println(person.getName()));
        persons.stream().forEach(person -> System.out.println(person.getAge()));
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("****************");
        persons.stream().filter(person -> person.getAge() == 19)
                .forEach(person -> System.out.println(person.getName()));


        System.out.println(persons.stream().findFirst().get().getName().toLowerCase());
        System.out.println(persons.stream().count());
    }
}