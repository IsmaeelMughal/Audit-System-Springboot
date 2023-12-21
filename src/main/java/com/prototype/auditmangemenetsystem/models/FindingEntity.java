package com.prototype.auditmangemenetsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "findings")
public class FindingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String formTitle;
    private String findings;
    private String findingRating;
    private String managementComments;
    private String postManagementComments;
    private String risk;
    private Boolean controlsInPlace;
    private String actionsRequired;
    private String deficiencies;
    private String controlEffectiveness;
    private String recommendation;
    private String responsibleDepartment;
    private String timeline;

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditEntity audit;
}
