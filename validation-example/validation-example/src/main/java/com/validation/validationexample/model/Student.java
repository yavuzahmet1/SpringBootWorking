package com.validation.validationexample.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "must be not null")
    @Size(min = 3)
    private String name;

    @NotBlank(message = "must be not blank")
    private String lastName;
    private String schoolName;

    @Email(message = "email should be valid")
    private String email;

    @Min(value = 10,message = "Cannot be younger than 10 years old")
    private int age;

    @Pattern(regexp = "[0-9\\s{12}]")
    private String phone;
}
