package com.igap.registry.repositories.user;

import com.igap.registry.entities.core.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
