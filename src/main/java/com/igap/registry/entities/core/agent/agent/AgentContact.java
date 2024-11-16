package com.igap.registry.entities.core.agent.agent;

import com.igap.registry.entities.base.BaseEntity;
import com.igap.registry.entities.core.enums.ContactType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AgentContact extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ContactType type;// Enum pour Type de contact (téléphone ou email)

    private String detailContact;  // Détail du contact (le numéro ou l'email)
}
