package com.igap.registry.entities.core.agent.agent;

import com.igap.registry.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Promotion extends BaseEntity {
    @Column
    private int promotionOrder;

    @Column
    private String referenceActe;

    @Column
    private Date promotionDate;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
