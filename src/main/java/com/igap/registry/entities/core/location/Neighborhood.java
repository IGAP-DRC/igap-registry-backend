package com.igap.registry.entities.core.location;

import com.igap.registry.entities.base.NameEntity;
import com.igap.registry.entities.core.agent.Agent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Neighborhood extends NameEntity {
    @ManyToOne
    @JoinColumn(name = "municipality_id", nullable = false)
    private Municipality municipality;

    @OneToMany(mappedBy = "quartier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agent> agents;
}
