package com.dailycodebuffer.deparmentservice.service;

import com.dailycodebuffer.deparmentservice.entity.Department;
import com.dailycodebuffer.deparmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
@Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return this.departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        return this.departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> getAll(Department department) {
        return this.departmentRepository.findAll();
    }
}
