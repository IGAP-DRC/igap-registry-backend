package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.OtherPosition;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OtherPositionService {

    OtherPosition saveOtherPosition(OtherPosition otherPosition);

    Optional<OtherPosition> findOtherPositionById(UUID id);

    List<OtherPosition> findAllOtherPositions();

    void deleteOtherPositionById(UUID id);

    OtherPosition updateOtherPosition(OtherPosition otherPosition);
}
