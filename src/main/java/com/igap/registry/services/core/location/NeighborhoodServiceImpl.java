package com.igap.registry.services.core.location;

import com.igap.registry.entities.core.location.Neighborhood;
import com.igap.registry.repositories.location.NeighborhoodRepository;
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
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;


    @Override
    public Neighborhood saveNeighborhood(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }

    @Override
    public Optional<Neighborhood> getNeighborhoodById(UUID id) {
        return neighborhoodRepository.findById(id);
    }

    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodRepository.findAll();
    }

    @Override
    public void deleteNeighborhood(UUID id) {
        neighborhoodRepository.deleteById(id);
    }

}