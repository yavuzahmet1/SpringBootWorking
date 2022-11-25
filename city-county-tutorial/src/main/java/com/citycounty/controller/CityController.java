package com.citycounty.controller;

import com.citycounty.model.City;
import com.citycounty.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(cityService.getAll(),OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {
        City city=getCityById(id);
        return new ResponseEntity<>(city, OK);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city)  {

        return new ResponseEntity<>(cityService.createCity(city), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCity(@PathVariable String id, @RequestBody City city) {
        cityService.update(id,city);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(OK);
    }

    private City getCityById(String id) {
        return cityService.getCityById(id);
    }

}
