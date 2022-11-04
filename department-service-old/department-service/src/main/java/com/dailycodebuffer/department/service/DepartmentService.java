package com.dailycodebuffer.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.department.entitiy.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartmet(Department department) {
		log.info("inside saveDepartment methot of DepartmentController ");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("inside saveDepartment methot of DepartmentService ");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
