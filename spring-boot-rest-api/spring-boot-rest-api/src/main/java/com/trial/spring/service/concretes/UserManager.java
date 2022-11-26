package com.trial.spring.service.concretes;

import com.trial.spring.dto.UserDto;
import com.trial.spring.entity.User;
import com.trial.spring.repository.UserRepository;
import com.trial.spring.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User>users=userRepository.findAll();
        List<UserDto>dtos=users.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return modelMapper.map(user.get(),UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<User> resultUser = userRepository.findById(id);
        if (resultUser.isPresent()){
            resultUser.get().setName(userDto.getName());
            resultUser.get().setLastName(userDto.getLastName());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdatedBy("Admin");

            return modelMapper.map(userRepository.save(resultUser.get()),UserDto.class);
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

    @Override
    public Page<User> pagination(int currentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currentPage,pageSize);
        return userRepository.findAll(pageable);
    }
}
