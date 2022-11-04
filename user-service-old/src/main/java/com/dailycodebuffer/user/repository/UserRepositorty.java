package com.dailycodebuffer.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.user.entity.User;

@Repository
public interface UserRepositorty extends JpaRepository<User, Long> {
	User findByUserId(Long userId);

}
