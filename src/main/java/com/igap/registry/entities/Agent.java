package com.igap.registry.entities;

import com.igap.registry.enums.AdminPosition;
import com.igap.registry.enums.Gender;
import com.igap.registry.enums.IdentityCardType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthPlace;
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private IdentityCardType identityCardType;

    @Enumerated(EnumType.STRING)
    private AdminPosition adminPosition;

    private String identityCardNumber;
    private Date identityCardIssueDate;
    private String identityCardIssuePlace;
    private Date identityCardExpiryDate;
    private String address;
    private String maritalStatus;
    private int numberOfChildren;
    private String agentIDNumber;
    private boolean isSalaried;
    private boolean receivesAllowance;
    private boolean isRegistered;
    private boolean hasBiometricCard;
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

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    @JoinColumn(name = "assignment_type")
    private AgentAssignment assignment;
}
