package com.igap.registry.entities.core.administrative;

import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Division extends NameEntity {
    @ManyToOne
    @JoinColumn(name = "directorate_id")
    private Directorate directorate;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Office> offices;
}
