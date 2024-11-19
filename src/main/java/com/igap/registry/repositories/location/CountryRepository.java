package com.igap.registry.repositories.location;

import com.igap.registry.entities.core.location.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}
