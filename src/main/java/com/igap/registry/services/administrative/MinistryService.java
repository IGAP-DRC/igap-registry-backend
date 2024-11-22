package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Ministry;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MinistryService {

    Ministry saveMinistry(Ministry ministry);

    Optional<Ministry> findMinistryById(UUID id);

    List<Ministry> findAllMinistries();

    void deleteMinistryById(UUID id);

    Ministry updateMinistry(Ministry ministry);
}
