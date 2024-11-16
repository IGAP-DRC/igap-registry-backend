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
public class GeneralDirectorate extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "general_secretariat_id")
    private GeneralSecretariat generalSecretariat;

    @OneToMany(mappedBy = "generalDirectorate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Directorate> directorates;
}
