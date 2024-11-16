package com.igap.registry.entities.helpers;

import java.text.Normalizer;

/**
 * class SlugEncoder
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public class SlugEncoder {
    public static String encode(String name) {
        if (name == null || name.isEmpty())
            return "";

        String slug = name.trim().replaceAll("\\s+", "-");
        slug = Normalizer.normalize(slug, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        slug = slug.toLowerCase();

        return slug;
    }
}
