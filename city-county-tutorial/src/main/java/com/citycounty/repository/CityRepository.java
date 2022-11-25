package com.citycounty.repository;

import com.citycounty.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,String> {
    List<City> findAllByName(String name);

    Optional<City> findByName(String name);
}
