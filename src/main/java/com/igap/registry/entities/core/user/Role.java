package com.igap.registry.entities.core.user;
import com.igap.registry.entities.base.NameEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Role extends NameEntity {

    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
