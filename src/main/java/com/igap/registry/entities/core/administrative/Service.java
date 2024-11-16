package com.igap.registry.entities.core.administrative;

import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Service extends NameEntity {
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;
}
