package com.igap.registry.entities.core.agent.agent;

import com.igap.registry.entities.base.BaseEntity;
import com.igap.registry.entities.core.administrative.OtherPosition;
import com.igap.registry.entities.core.enums.AdminPosition;
import com.igap.registry.entities.core.enums.Gender;
import com.igap.registry.entities.core.enums.IdentityCardType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Agent extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String middleName;

    @Column
    private String birthPlace;

    @Column
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private IdentityCardType identityCardType;

    @Enumerated(EnumType.STRING)
    private AdminPosition adminPosition;

    @Column
    private String identityCardNumber;

    @Column
    private Date identityCardIssueDate;

    @Column
    private String identityCardIssuePlace;

    @Column
    private Date identityCardExpiryDate;

    @Column
    private String address;

    @Column
    private String maritalStatus;

    @Column
    private int numberOfChildren;

    @Column
    private String agentIDNumber;

    @Column
    private boolean isSalaried;

    @Column
    private boolean receivesAllowance;

    @Column
    private boolean isRegistered;

    @Column
    private boolean hasBiometricCard;

    @Column
    private String biometricCardNumber;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgentGrade> grades;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_id")
    private List<EmergencyContact> emergencies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_id")
    private List<Promotion> promotions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_id")
    private List<OtherPosition> otherPositions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_id")
    private List<CommissionAffectation> commissions;

}
