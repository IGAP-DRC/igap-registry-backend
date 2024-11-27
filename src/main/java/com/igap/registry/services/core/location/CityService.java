package com.igap.registry.services.core.location;

import com.igap.registry.entities.core.location.City;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CityService {

        City saveCity(City city);

        Optional<City> getCityById(UUID id);

        List<City> getAllCities();

        void deleteCity(UUID id);


}
