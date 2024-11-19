package com.igap.registry.services.location;

import com.igap.registry.entities.core.location.Neighborhood;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NeighborhoodService {

    Neighborhood saveNeighborhood(Neighborhood neighborhood);

    Optional<Neighborhood> getNeighborhoodById(UUID id);

    List<Neighborhood> getAllNeighborhoods();

    void deleteNeighborhood(UUID id);
}
