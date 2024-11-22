package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Ministry;
import com.igap.registry.repositories.administrative.MinistryRepository;
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
public class MinistryServiceImpl implements MinistryService {

    private final MinistryRepository ministryRepository;



    @Override
    public Ministry saveMinistry(Ministry ministry) {
        return ministryRepository.save(ministry);
    }

    @Override
    public Optional<Ministry> findMinistryById(UUID id) {
        return ministryRepository.findById(id);
    }

    @Override
    public List<Ministry> findAllMinistries() {
        return ministryRepository.findAll();
    }

    @Override
    public void deleteMinistryById(UUID id) {
        ministryRepository.deleteById(id);
    }

    @Override
    public Ministry updateMinistry(Ministry ministry) {
        return ministryRepository.save(ministry);
    }
}