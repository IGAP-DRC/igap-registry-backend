package com.igap.registry.entities;

import com.igap.registry.enums.ContactType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentContact {
    private Long id;
    @Enumerated(EnumType.STRING)
    private ContactType type;  // Enum pour Type de contact (téléphone ou email)
    private String detailContact;  // Détail du contact (le numéro ou l'email)

}
