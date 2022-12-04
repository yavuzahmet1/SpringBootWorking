package com.javaeducation.commerence.service.concretes;

import com.javaeducation.commerence.entity.Employee;
import com.javaeducation.commerence.exception.ResourceNotFoundException;
import com.javaeducation.commerence.repository.EmployeeRepository;
import com.javaeducation.commerence.service.abstracts.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
    }
