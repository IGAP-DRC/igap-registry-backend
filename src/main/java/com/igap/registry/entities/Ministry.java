package com.igap.registry.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ministry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "ministry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneralSecretariat> generalSecretariats;
}
