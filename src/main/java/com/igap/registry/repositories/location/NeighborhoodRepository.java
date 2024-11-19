package com.igap.registry.repositories.location;

import com.igap.registry.entities.core.location.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author riddy ndoma
 */
public interface NeighborhoodRepository  extends JpaRepository<Neighborhood, UUID> {
}
