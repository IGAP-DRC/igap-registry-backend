package com.igap.registry.entities.core.administrative;

import com.igap.registry.entities.base.NameEntity;
import com.igap.registry.entities.core.enums.NatureActe;
import com.igap.registry.entities.core.enums.TypePosition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OtherPosition extends NameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypePosition typePosition;

    @Enumerated(EnumType.STRING)
    private NatureActe natureAct;

    private String referenceAct;
    private Date dateSignature;
    private int duration;
}
