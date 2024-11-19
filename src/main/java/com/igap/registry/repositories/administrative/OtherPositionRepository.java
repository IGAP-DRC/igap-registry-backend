package com.igap.registry.repositories.administrative;

import com.igap.registry.entities.core.administrative.OtherPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author riddy ndoma
 */
public interface OtherPositionRepository extends JpaRepository<OtherPosition, UUID> {
}
