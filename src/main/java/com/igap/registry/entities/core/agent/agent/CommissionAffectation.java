package com.igap.registry.entities.core.agent.agent;

import com.igap.registry.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CommissionAffectation extends BaseEntity {
    @Column
    private boolean hasCommission;

    @Column
    private String referenceAct;

    @Column
    private Date dateSignature;

    @Column
    private String signAct;
}
