package com.citycounty.service;

import com.citycounty.model.City;
import com.citycounty.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City createCity(City city){

        Optional<City> cityByName = cityRepository.findByName(city.getName());
        if (cityByName.isPresent()) {
            System.out.println("Il already exists with name: " + city.getName());
        }

        return cityRepository.save(city);
    }


        public void deleteCity (String id){
            cityRepository.deleteById(id);
        }

        public City getCityById (String id){
            return cityRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("City is not found"));
        }

        public void update (String id, City city){
            City oldCity = getCityById(id);
            oldCity.setName(city.getName());
            cityRepository.save(oldCity);
        }
    }
