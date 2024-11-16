package com.igap.registry.entities.core.agent.agent;

import com.igap.registry.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class EmergencyContact extends BaseEntity {
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String middleName;

    @Column
    private String relationship;

    @Column
    private String phone;

    @Column
    private String email;
}
