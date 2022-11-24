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
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("City is not found"));
    }
}
