package com.igap.registry.entities.core.agent.education;


import com.igap.registry.entities.base.BaseEntity;
import com.igap.registry.entities.core.agent.agent.Agent;
import com.igap.registry.entities.core.location.City;
import com.igap.registry.entities.core.location.Country;
import com.igap.registry.entities.core.location.Province;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

/**
 * class AcademicHistory
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@NoArgsConstructor
public class AcademicHistory extends BaseEntity {

    @Column
    protected Integer yearOfGraduation;

    @Column
    protected Double percentage;

    @Column
    protected String nameOfEducationalInstitution;

    @Column
    protected String reference;

    @Column
    protected Integer diplomaType;

    @Column
    protected LocalDate diplomaDeliveryDate;

    @ManyToOne
    @JoinColumn(name = "countryOfEducationInstitution")
    private Country countryOfEducationInstitution;

    @ManyToOne
    @JoinColumn(name = "provinceOfEducationInstitution")
    private Province provinceOfEducationInstitution;

    @ManyToOne
    @JoinColumn(name = "cityOfEducationInstitution")
    private City cityOfEducationInstitution;

    @ManyToOne
    @JoinColumn(name = "program")
    private AcademicProgram program;

    @ManyToOne
    @JoinColumn(name = "levelEducation")
    private LevelEducation levelEducation;

    @ManyToOne
    @JoinColumn(name = "agent")
    private Agent agent;


    @Transient
    public DiplomaType getDiplomaType() {
        return DiplomaType.fromId(diplomaType);
    }

    public void setDiplomaType(DiplomaType diplomaType) {
        this.diplomaType = diplomaType.getId();
    }
}
