package com.studentAmigos.studentamigoscode.api;

import com.studentAmigos.studentamigoscode.entity.Person;
import com.studentAmigos.studentamigoscode.service.PersonManager;
import com.studentAmigos.studentamigoscode.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/add")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;

    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson (person);
    }

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    public Person getPersonById(UUID id){
        return personService.getPersonById(id);
    }
}
