package com.dailycode.streamapitutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiTutorialApplication {
    static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(
                new Employee("Ahmet", "Yavuz", 2000.0, List.of("Projet 1", "Project 2")));
        employees.add(
                new Employee("Mehmet", "Hasim", 1000.0, List.of("Projet 3", "Project 4")));
        employees.add(
                new Employee("Hale", "Zahar", 3000.0, List.of("Projet 6", "Project 5")));

    }

    public static void main(String[] args) throws NoSuchFieldException {
        //SpringApplication.run(StreamApiTutorialApplication.class, args);
        //foreach
        employees.stream()
                .forEach(employee -> System.out.println(employee));

        //map
        //collect
        Set<Employee> increasedSalSet =
                employees.stream()
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .collect(Collectors.toSet());
        System.out.println(increasedSalSet);
        List<Employee> increasedSalList =
                employees.stream()
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .collect(Collectors.toList());

        System.out.println(increasedSalList);

        //filter
        //findFirst
        List<Employee> filterEmployee =
                employees.stream()
                        .filter(employee -> employee.getSalary() < 3000.0)
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .collect(Collectors.toList());
        System.out.println(filterEmployee);

        Employee findFirstEmployee =
                employees.stream()
                        .filter(employee -> employee.getSalary() < 2000.0)
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                        .findFirst()
                        .orElse(null);
        System.out.println(findFirstEmployee);

        //flatMap
        String projects =
                employees.stream()
                        .map(employee -> employee.getProjects())
                        .flatMap(strings -> strings.stream())
                        .collect(Collectors.joining(","));
        System.out.println(projects);

        //short Circuit operations
        List<Employee> shortCircuit =
                employees.stream()
                        .skip(1)
                        .limit(1)
                        .collect(Collectors.toList());
        System.out.println(shortCircuit);

        //finite Data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        //sorting
        List<Employee> sortedEmployees =
                employees.stream()
                        .sorted((o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                        .collect(Collectors.toList());
        System.out.println(sortedEmployees);

            //min or max
        employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchFieldException::new);

        //reduce
        Double toToSalary=employees.stream()
                .map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);
        System.out.println(toToSalary);

    }

}
///steam classes
