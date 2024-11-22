package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.OtherPosition;
import com.igap.registry.repositories.administrative.OtherPositionRepository;
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
public class OtherPositionServiceImpl implements OtherPositionService {

    private final OtherPositionRepository otherPositionRepository;

    @Override
    public OtherPosition saveOtherPosition(OtherPosition otherPosition) {
        return otherPositionRepository.save(otherPosition);
    }

    @Override
    public Optional<OtherPosition> findOtherPositionById(UUID id) {
        return otherPositionRepository.findById(id);
    }

    @Override
    public List<OtherPosition> findAllOtherPositions() {
        return otherPositionRepository.findAll();
    }

    @Override
    public void deleteOtherPositionById(UUID id) {
        otherPositionRepository.deleteById(id);
    }

    @Override
    public OtherPosition updateOtherPosition(OtherPosition otherPosition) {
        return otherPositionRepository.save(otherPosition);
    }
}