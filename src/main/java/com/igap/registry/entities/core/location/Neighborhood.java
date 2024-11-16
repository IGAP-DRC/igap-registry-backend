package com.igap.registry.entities.core.location;

import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Neighborhood extends NameEntity {
    @ManyToOne
    @JoinColumn(name = "municipality_id", nullable = false)
    private Municipality municipality;
}
