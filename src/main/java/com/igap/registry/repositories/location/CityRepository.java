package com.igap.registry.repositories.location;

import com.igap.registry.entities.core.location.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}
