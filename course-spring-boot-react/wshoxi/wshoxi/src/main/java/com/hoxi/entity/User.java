package com.hoxi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2,max = 20)
    private String userName;
    @NotNull
    @Size(min = 2,max = 20)
    private String displayName;
    @NotNull
    @Size(min = 2,max = 20)
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
