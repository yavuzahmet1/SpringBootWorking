package com.trial.spring.service.concretes;

import com.trial.spring.entity.User;
import com.trial.spring.repository.UserRepository;
import com.trial.spring.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        //User newUser=new User();
        user.setCreatedDate(new Date());
        user.setUpdatedBy("Admin");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> resultUser = userRepository.findById(id);
        if (resultUser.isPresent()){
            resultUser.get().setName(user.getName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdatedBy("Admin");

            return userRepository.save(resultUser.get());
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
