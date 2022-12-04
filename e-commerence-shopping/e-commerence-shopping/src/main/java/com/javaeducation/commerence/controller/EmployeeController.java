package com.javaeducation.commerence.controller;

import com.javaeducation.commerence.entity.Employee;
import com.javaeducation.commerence.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>("Employee deleted successfully!.",HttpStatus.OK);
    }
}
//1.02.00
//https://www.youtube.com/watch?v=4Ico2HjRTCE
