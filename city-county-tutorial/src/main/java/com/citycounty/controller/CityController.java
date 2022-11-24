package com.citycounty.controller;

import com.citycounty.model.City;
import com.citycounty.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    /*private static final List<City> cities = new ArrayList<>();

    public CityController() {
        if (cities.isEmpty()) {
            City city = new City("51", "Nigde", new Date());
            City city1 = new City("34", "Istanbul", new Date());
            cities.add(city);
            cities.add(city1);
        }
    }*/

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {
        City city=getCityById(id);
        return new ResponseEntity<>(city, OK);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {

        return new ResponseEntity<>(cityService.createCity(city), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCity(@PathVariable String id, @RequestBody City city) {
        City oldCity = getCityById(id);
        oldCity.setName(city.getName());
        oldCity.setCreateDate(new Date());
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        City city = getCityById(id);
        cities.remove(city);
        return new ResponseEntity<>(OK);
    }

    private City getCityById(String id) {
        return cities.stream()
                .filter(city -> city.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("City is not found"));
    }

}
