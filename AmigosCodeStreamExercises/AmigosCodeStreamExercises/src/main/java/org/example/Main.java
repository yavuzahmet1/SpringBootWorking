package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        //BAD CODE
        List<Person> female=new ArrayList<>();
        for (Person person:people){
            if (person.getGender().equals("female")){
                female.add(person);
            }
        }
        female.forEach(System.out::println);

        System.out.println("Streams=> Filter used");
        List<Person>femalesFilter= people.stream()
                .filter(person -> person.getGender().equals("female"))
                .toList();
        femalesFilter.forEach(System.out::println);
        System.out.println("Streams=> Sort used");
        List<Person>sortedUsed= people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                        .toList();
        sortedUsed.forEach(System.out::println);
    }

    public static List<Person> getPeople() {
        return List.of(
                new Person("Ahmet YAVUZ", 34, "male"),
                new Person("Osman", 29, "male"),
                new Person("Ayşe", 26, "female"),
                new Person("Hale", 22, "female"),
                new Person("Alex", 39, "male")
        );
    }
}