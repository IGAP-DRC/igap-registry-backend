package com.igap.registry.services.core.location;

import com.igap.registry.entities.core.location.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountryService {
    Country saveCountry(Country country);

    Optional<Country> getCountryById(UUID id);

    List<Country> getAllCountries();

    void deleteCountry(UUID id);
}
