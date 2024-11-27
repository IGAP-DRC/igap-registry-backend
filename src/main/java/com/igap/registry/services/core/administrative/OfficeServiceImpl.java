package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.Office;
import com.igap.registry.repositories.administrative.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Optional<Office> findOfficeById(UUID id) {
        return officeRepository.findById(id);
    }

    @Override
    public List<Office> findAllOffices() {
        return officeRepository.findAll();
    }

    @Override
    public void deleteOfficeById(UUID id) {
        officeRepository.deleteById(id);
    }

    @Override
    public Office updateOffice(Office office) {
        return officeRepository.save(office);
    }
}