package com.igap.registry.services.core.agent;

import com.igap.registry.entities.core.agent.EmergencyContact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmergencyContactService {

    EmergencyContact saveEmergencyContact(EmergencyContact emergencyContact);

    Optional<EmergencyContact> findEmergencyContactById(UUID id);

    List<EmergencyContact> findAllEmergencyContacts();

    void deleteEmergencyContactById(UUID id);

    EmergencyContact updateEmergencyContact(EmergencyContact emergencyContact);
}