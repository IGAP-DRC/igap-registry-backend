package com.igap.registry.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class GeneralDirectorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "general_secretariat_id")
    private GeneralSecretariat generalSecretariat;

    @OneToMany(mappedBy = "generalDirectorate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Directorate> directorates;
}
