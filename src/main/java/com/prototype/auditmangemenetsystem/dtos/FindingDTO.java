package com.prototype.auditmangemenetsystem.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FindingDTO {
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
    private AuditDTO audit;
}
