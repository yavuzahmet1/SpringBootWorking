package com.studentAmigos.studentamigoscode.service;

import com.studentAmigos.studentamigoscode.entity.Person;
import com.studentAmigos.studentamigoscode.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonManager implements PersonService{
    private final PersonDao personDao;

    @Autowired
    public PersonManager(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {

        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson(){
        return personDao.getAll();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
}
