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
public class Ministry extends NameEntity {
    @OneToMany(mappedBy = "ministry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneralSecretariat> generalSecretariats;
}
