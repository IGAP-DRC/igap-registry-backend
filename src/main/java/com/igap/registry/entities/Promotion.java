package com.igap.registry.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int promotionOrder;
    private String referenceActe;
    private Date promotionDate;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
