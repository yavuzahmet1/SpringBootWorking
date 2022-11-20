package org.javaStream;

import java.util.Comparator;
import java.util.List;

public class MaxAndComparator {


    public static Person getOldestPerson(List<Person> people) {
        Person oldestPerson = new Person("", 0);
        for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

    public static Person getOldestPerson2(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);
    }
    //.max()--->personun içindeki tüm ageleri karşılaştır en büyük age'yi bana getir.
}

