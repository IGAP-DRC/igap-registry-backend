package com.igap.registry.entities.core.location;

import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * class Municipality
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Municipality extends NameEntity {
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "municipality")
    protected List<Neighborhood> neighborhoods;
}
