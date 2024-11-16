package com.igap.registry.entities.core.agent.education;


import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

/**
 * class DiplomaType
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
public enum DiplomaType {

    LICENCE(1, "Licence"),
    MASTER(2, "Master"),
    DOCTORATE(2, "Doctorate"),
    GRADUATE(3, "Graduate"),;

    private final Integer id;
    private final String name;
    private static final Map<Integer, DiplomaType> ID = new HashMap<>();
    private static final Map<String, DiplomaType> NAME = new HashMap<>();

    static {
        for (DiplomaType type : DiplomaType.values()) {
            ID.put(type.getId(), type);
            NAME.put(type.getName().toLowerCase(), type);
        }
    }

    DiplomaType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static DiplomaType fromId(Integer id) {
        return ID.get(id);
    }

    public static DiplomaType fromName(String name) {
        return NAME.get(name.toLowerCase());
    }

    @Override
    public String toString() {
        return name;
    }
}
