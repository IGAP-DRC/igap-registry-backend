package com.igap.registry.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Directorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "general_directorate_id")
    private GeneralDirectorate generalDirectorate;

    @OneToMany(mappedBy = "directorate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Division> divisions;
}
