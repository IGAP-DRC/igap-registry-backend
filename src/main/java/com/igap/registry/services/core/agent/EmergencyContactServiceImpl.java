package com.igap.registry.services.core.agent;

import com.igap.registry.entities.core.agent.EmergencyContact;
import com.igap.registry.repositories.agent.EmergencyContactRepository;
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
public class EmergencyContactServiceImpl implements EmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;


    @Override
    public EmergencyContact saveEmergencyContact(EmergencyContact emergencyContact) {
        return emergencyContactRepository.save(emergencyContact);
    }

    @Override
    public Optional<EmergencyContact> findEmergencyContactById(UUID id) {
        return emergencyContactRepository.findById(id);
    }

    @Override
    public List<EmergencyContact> findAllEmergencyContacts() {
        return emergencyContactRepository.findAll();
    }

    @Override
    public void deleteEmergencyContactById(UUID id) {
        emergencyContactRepository.deleteById(id);
    }

    @Override
    public EmergencyContact updateEmergencyContact(EmergencyContact emergencyContact) {
        return emergencyContactRepository.save(emergencyContact);
    }
}
