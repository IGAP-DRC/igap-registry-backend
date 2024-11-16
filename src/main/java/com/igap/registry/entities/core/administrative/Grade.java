package com.igap.registry.entities.core.administrative;

import com.igap.registry.entities.base.BaseEntity;
import com.igap.registry.entities.core.agent.AgentGrade;
import com.igap.registry.entities.core.agent.Promotion;
import com.igap.registry.entities.core.enums.CategoryGrade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Grade extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryGrade category;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgentGrade> agentGrades;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Promotion> promotions;
}
