package com.example.yvzbytes.tutorial.service.concretes;

import com.example.yvzbytes.tutorial.dto.PersonDto;
import com.example.yvzbytes.tutorial.entity.Address;
import com.example.yvzbytes.tutorial.entity.Person;
import com.example.yvzbytes.tutorial.repository.AddressRepository;
import com.example.yvzbytes.tutorial.repository.PersonRepository;
import com.example.yvzbytes.tutorial.service.abstracts.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonManager implements PersonService {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    public PersonDto save(PersonDto personDto) {
        //Assert.isNull(personDto.getName(),"Name field must not empty!!");
        Person person = new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        final Person personDb = personRepository.save(person);
        List<Address> addressLists = new ArrayList<>();
        personDto.getAddressList().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setIsActive(true);
            address.setPerson(personDb);
            addressLists.add(address);
        });
        addressRepository.saveAll(addressLists);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(PersonDto personDto) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person>people=personRepository.findAll();
        List<PersonDto> personDtos=new ArrayList<>();
        people.forEach(it->{
            PersonDto personDto=new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setLastName(it.getLastName());
            personDto.setAddressList(it.getAddressList().stream()
                    .map(Address::getAddress)
                    .collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll2(Pageable pageable) {
        return null;
    }
}
