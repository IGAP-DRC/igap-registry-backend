package com.igap.registry.repositories.administrative;

import com.igap.registry.entities.core.administrative.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author riddy ndoma
 */
public interface ServiceRepository extends JpaRepository<Service, UUID> {
}
