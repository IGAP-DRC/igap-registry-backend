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
public class GeneralSecretariat extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "ministry_id")
    private Ministry ministry;

    @OneToMany(mappedBy = "generalSecretariat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneralDirectorate> generalDirectorates;
}
