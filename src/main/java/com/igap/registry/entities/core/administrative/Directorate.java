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
public class Directorate extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "general_directorate_id")
    private GeneralDirectorate generalDirectorate;

    @OneToMany(mappedBy = "directorate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Division> divisions;
}
