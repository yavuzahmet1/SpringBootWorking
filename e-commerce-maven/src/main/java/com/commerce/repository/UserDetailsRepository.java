package com.commerce.repository;

import com.commerce.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<Long, UserDetails> {
}
