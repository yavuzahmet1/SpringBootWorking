package com.hoxi;

import com.hoxi.entity.User;
import com.hoxi.repository.UserRepository;
import com.hoxi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//Spring Security pom.xml'de yüklü olduğunbdan güvenlik gerekçesiyle password isteyecektir.
//işte bunu geçici olarak kaldırabiliriz bunun için (exclude=SecurityAutoConfiguration.class) yazılır ve
//geçici oarak bunu devredışı brakabiliriz.
public class WshoxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WshoxiApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUsers(UserService userService) {
        return (args) -> {
            User user = new User();
            user.setUserName("user1");
            user.setDisplayName("display1");
            user.setPassword("P4ssword");
            userService.saveUser(user);

        };
    }
}


