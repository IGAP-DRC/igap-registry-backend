package com.igap.registry.entities.core.agent;

import com.igap.registry.entities.base.BaseEntity;
import com.igap.registry.entities.core.enums.GradeType;
import com.igap.registry.entities.core.enums.NatureActe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class AgentGrade extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    @Enumerated(EnumType.STRING)
    private NatureActe natureActe;

    private Date dateSignature;
    private String referenceActe;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
