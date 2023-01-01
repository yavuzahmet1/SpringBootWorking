package com.dailycode.streamapitutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StreamApiTutorialApplication {
    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(
                new Employee("Ahmet","Yavuz",2000.0,List.of("Projet 1","Project 2")));
        employees.add(
                new Employee("Mehmet","Hasim",1000.0,List.of("Projet 3","Project 4")));
        employees.add(
                new Employee("Hale","Zahar",3000.0,List.of("Projet 6","Project 5")));

    }

    public static void main(String[] args) {
        SpringApplication.run(StreamApiTutorialApplication.class, args);
    }

}
