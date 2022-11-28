package com.example.yvzbytes.tutorial.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of={"id"})
public class PersonDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    private List<String> addressList;

}
