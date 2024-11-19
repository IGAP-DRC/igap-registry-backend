package com.igap.registry.repositories.user;

import com.igap.registry.entities.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {
}
