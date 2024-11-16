package com.igap.registry.entities.base;

import com.igap.registry.entities.helpers.SlugEncoder;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;


/**
 * class NameEntity
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class NameEntity extends BaseEntity {

    @Column
    protected String name;

    public NameEntity(UUID id) {
        super(id);
        this.slug = SlugEncoder.encode(name);
    }

    public NameEntity(UUID id, String name) {
        super(id);
        this.name = name;
        this.slug = SlugEncoder.encode(name);
    }

    protected NameEntity(String name) {
        this.name = name;
        this.slug = SlugEncoder.encode(name);
    }

    protected NameEntity(String slug, String name) {
        super(slug);
        this.name = name;
        this.slug = SlugEncoder.encode(name);
    }
}
