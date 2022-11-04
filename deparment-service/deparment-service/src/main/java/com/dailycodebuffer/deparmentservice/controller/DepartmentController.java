package com.dailycodebuffer.deparmentservice.controller;

import com.dailycodebuffer.deparmentservice.entity.Department;
import com.dailycodebuffer.deparmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }
}
