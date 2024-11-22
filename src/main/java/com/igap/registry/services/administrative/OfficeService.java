package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Office;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfficeService {

    Office saveOffice(Office office);

    Optional<Office> findOfficeById(UUID id);

    List<Office> findAllOffices();

    void deleteOfficeById(UUID id);

    Office updateOffice(Office office);
}