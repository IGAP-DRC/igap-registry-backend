package com.igap.registry.services.core.location;

import com.igap.registry.entities.core.location.Country;
import com.igap.registry.repositories.location.CountryRepository;
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
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;


    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> getCountryById(UUID id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void deleteCountry(UUID id) {
        countryRepository.deleteById(id);
    }

}
