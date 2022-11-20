package org.javaStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {


    }
    public  Map<String, List<Person>> groupByNationality(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new ArrayList<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;
    }
    public  Map<String, List<Person>> groupByNationality2(List<Person> people) {

        return people.stream()
                .collect(Collectors.groupingBy(Person::getNationality,Collectors.toList()));//lambda biçimi

        /*return people.stream()
                .collect(Collectors.groupingBy(person -> person.getNationality(),Collectors.toList())*/
    }
}
