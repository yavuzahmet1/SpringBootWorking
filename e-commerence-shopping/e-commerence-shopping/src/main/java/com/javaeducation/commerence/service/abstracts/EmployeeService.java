package com.javaeducation.commerence.service.abstracts;

import com.javaeducation.commerence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAll();

    void delete(Long id);

    Employee getById(Long id);
}
