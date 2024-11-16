package com.igap.registry.entities.base;


import com.igap.registry.entities.helpers.IdentityGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * class BaseEntity
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable  {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime createdAt;

    @Column
    @CreatedBy
    protected UUID createdBy;


    @Column
    @LastModifiedDate
    protected LocalDateTime updatedAt;


    @Column
    @LastModifiedBy
    protected UUID updatedBy;


    @Column
    protected LocalDateTime deletedAt;
    
    @Column
    protected UUID deletedBy;

    @Column(nullable = false)
    protected Boolean isDeleted;

    @Column
    protected String slug;

    @Column
    protected Integer deletedReason;

    @Column(unique = true)
    protected String referenceNumber;

    
    public BaseEntity(String slug) {
        this.slug = slug;
        this.createdAt = LocalDateTime.now();
        this.referenceNumber = IdentityGenerator.getRandomNumeric(15);
        this.isDeleted = Boolean.FALSE;
    }

    public BaseEntity(){
        this.createdAt = LocalDateTime.now();
        this.referenceNumber = IdentityGenerator.getRandomNumeric(15);
        this.isDeleted = Boolean.FALSE;
    }

    public BaseEntity(UUID id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.referenceNumber = IdentityGenerator.getRandomNumeric(15);
        this.isDeleted = Boolean.FALSE;
    }


    @Transient
    public DeletedReason getDeletedReason() {
        return DeletedReason.fromId(deletedReason);
    }

    public void setDeletedReason(DeletedReason deletedReason) {
        this.deletedReason = deletedReason.getId();
    }


    @PrePersist
    public void prePersist(){
        this.isDeleted = Boolean.FALSE;
        this.deletedAt = null;
    }

}
