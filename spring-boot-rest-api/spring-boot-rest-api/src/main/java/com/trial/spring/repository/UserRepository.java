package com.trial.spring.repository;

import com.trial.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   /* User findByName(String name);
    User findByNameAndLastName(String name);*/
}
