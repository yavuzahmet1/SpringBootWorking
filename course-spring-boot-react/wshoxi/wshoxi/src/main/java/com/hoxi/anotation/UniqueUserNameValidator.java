package com.hoxi.anotation;

import com.hoxi.entity.User;
import com.hoxi.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {
    private UserRepository userRepository;

    public UniqueUserNameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            return false;
        }
        return true;
    }
}
