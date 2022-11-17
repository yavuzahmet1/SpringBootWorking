package com.demoLibrary.demo.dtos.author.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorListResponse {
    private Long id;
    private String name;
}
