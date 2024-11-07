package com.igap.registry.entities;

import com.igap.registry.enums.NatureActe;
import com.igap.registry.enums.TypePosition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class OtherPosition {
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
