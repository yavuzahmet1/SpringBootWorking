package com.dailycodebuffer.deparmentservice.service;

import com.dailycodebuffer.deparmentservice.entity.Department;
import com.dailycodebuffer.deparmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
