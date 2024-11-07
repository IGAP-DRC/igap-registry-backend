package com.igap.registry.entities;

import com.igap.registry.enums.GradeType;
import com.igap.registry.enums.NatureActe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class AgentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
