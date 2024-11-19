package com.igap.registry.entities.core.agent.education;


import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * class LevelEducation
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class LevelEducation extends NameEntity {

    public LevelEducation(String name) {
        this.name = name;
    }

    public LevelEducation(UUID id) {
        super(id);
    }
}
