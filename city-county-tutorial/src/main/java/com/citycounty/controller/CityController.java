package com.citycounty.controller;

import com.citycounty.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private static final List<City> cities=new ArrayList<>();

    /* @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
     public List<City> getAll1() {
         City city=new City("51","Nigde");
         City city1=new City("34","Istanbul");
         List<City> cities= Arrays.asList(city,city1);
         return Arrays.asList(city,city1); //aşagıdaki ile farkı HTTPStatusu @ResponseStatus'u @GetMaping!in altına ekleyecektik
         ama bu doğru bir kullanım değildir.
     }*/
    public CityController() {
        if (cities.isEmpty()){
            City city = new City("51", "Nigde",new Date());
            City city1 = new City("34", "Istanbul",new Date());
            cities .add(city);
            cities.add(city1);
        }

    }

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable String id) {
        City result=cities.stream()
                .filter(city -> city.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new RuntimeException("City is not found"));
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city){
        city.setCreateDate(new Date());
        cities.add(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCity(@PathVariable String id,City city){

    }
}
