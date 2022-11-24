package com.citycounty.service;

import com.citycounty.model.City;
import com.citycounty.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }
    public City createCity(City city) {
        return null;
    }
}
