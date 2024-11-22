package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceService {

    Service saveService(Service service);

    Optional<Service> findServiceById(UUID id);

    List<Service> findAllServices();

    void deleteServiceById(UUID id);

    Service updateService(Service service);
}