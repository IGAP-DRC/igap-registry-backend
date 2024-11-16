package com.igap.registry.entities.base;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


/**
 * class DeletedReason
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
public enum DeletedReason {

    BAD_DATA(1,"Bad data"),
    DATA_CREATED_BY_MISTAKE_AND_MORE(2,"Data created by mistake and more");

    private final Integer id;
    private final String name;
    private static final Map<Integer, DeletedReason> MAP = new HashMap<>();
    private static final Map<String, DeletedReason> NAME = new HashMap<>();

    static {
        for (DeletedReason deletedReason : DeletedReason.values()) {
            MAP.put(deletedReason.getId(), deletedReason);
            NAME.put(deletedReason.getName().toLowerCase(), deletedReason);
        }
    }

    DeletedReason(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static DeletedReason fromId(Integer id) {
        return MAP.get(id);
    }

    public static DeletedReason fromName(String name) {
        return NAME.get(name.toLowerCase());
    }

    @Override
    public String toString() {
        return name;
    }

}
