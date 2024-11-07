package com.igap.registry.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class GeneralSecretariat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ministry_id")
    private Ministry ministry;

    @OneToMany(mappedBy = "generalSecretariat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneralDirectorate> generalDirectorates;
}
