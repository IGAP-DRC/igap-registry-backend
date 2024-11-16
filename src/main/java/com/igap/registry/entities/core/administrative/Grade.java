package com.igap.registry.entities.core.administrative;

import com.igap.registry.entities.base.BaseEntity;
import com.igap.registry.entities.core.enums.CategoryGrade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grade extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CategoryGrade category;
}
