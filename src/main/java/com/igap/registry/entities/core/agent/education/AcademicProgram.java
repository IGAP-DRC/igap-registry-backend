package com.igap.registry.entities.core.agent.education;


import com.igap.registry.entities.base.NameEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

/**
 * class AcademicProgram
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@NoArgsConstructor
public class AcademicProgram extends NameEntity {

    public AcademicProgram(String name) {
        this.name = name;
    }

    public AcademicProgram(UUID id) {
        super(id);
    }
}
