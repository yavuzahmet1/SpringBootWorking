package com.javabackend.springbootbackendprj.controller;

import com.javabackend.springbootbackendprj.model.Employee;
import com.javabackend.springbootbackendprj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getall")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
}
