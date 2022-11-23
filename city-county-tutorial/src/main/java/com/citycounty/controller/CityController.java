package com.citycounty.controller;

import com.citycounty.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

   /* @GetMapping
   @ResponseStatus(HttpStatus.CREATED)
    public List<City> getAll1() {
        City city=new City("51","Nigde");
        City city1=new City("34","Istanbul");
        List<City> cities= Arrays.asList(city,city1);
        return Arrays.asList(city,city1); //aşagıdaki ile farkı HTTPStatusu @ResponseStatus'u @GetMaping!in altına ekleyecektik
        ama bu doğru bir kullanım değildir.
    }*/

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        City city=new City("51","Nigde");
        City city1=new City("34","Istanbul");
        List<City> cities= Arrays.asList(city,city1);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
