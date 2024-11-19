package com.igap.registry.services.location;

import com.igap.registry.entities.core.location.City;
import com.igap.registry.repositories.location.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> getCityById(UUID id) {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteCity(UUID id) {
        cityRepository.deleteById(id);
    }
}
