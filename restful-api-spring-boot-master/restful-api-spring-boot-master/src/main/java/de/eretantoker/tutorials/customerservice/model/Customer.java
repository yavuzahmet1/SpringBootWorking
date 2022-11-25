package de.eretantoker.tutorials.customerservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Customer {
    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Integer age;
}
