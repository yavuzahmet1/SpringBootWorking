package com.javabackend.springbootbackendprj.repository;

import com.javabackend.springbootbackendprj.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
