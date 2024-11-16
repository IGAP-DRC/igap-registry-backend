package com.igap.registry.entities.core.location;

import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
/**
 * class Province
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Province extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;
}
