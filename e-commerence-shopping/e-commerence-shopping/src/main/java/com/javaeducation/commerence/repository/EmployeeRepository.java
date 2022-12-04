package com.javaeducation.commerence.repository;

import com.javaeducation.commerence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    

}
