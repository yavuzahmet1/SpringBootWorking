package com.example.yvzbytes.tutorial.service.abstracts;

import com.example.yvzbytes.tutorial.dto.PersonDto;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    PersonDto save(PersonDto personDto);
    void delete(PersonDto personDto);
    List<PersonDto> getAll();
    Page<PersonDto> getAll2(Pageable pageable);
}
