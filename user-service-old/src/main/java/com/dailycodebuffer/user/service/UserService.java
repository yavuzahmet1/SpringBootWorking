package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepositorty;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	private UserRepositorty userRepositorty;
	private RestTemplate restTemplate;

	@Autowired
	public UserService(UserRepositorty userRepositorty,RestTemplate restTemplate) {
		this.userRepositorty = userRepositorty;
		this.restTemplate=restTemplate;
	}

	public User saveUser(User user) {
		log.info("Inside saveUser of userService");
		return this.userRepositorty.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of userService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = this.userRepositorty.findByUserId(userId);
		Department department = this.restTemplate.getForObject("http://localhost:2300/departments/" + user.getDepartmentId(),
				Department.class);

		vo.setUser(user);
		vo.setDepartment(department);

		return vo;

	}
}
