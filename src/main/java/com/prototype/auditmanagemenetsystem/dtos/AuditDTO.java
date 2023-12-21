package com.prototype.auditmanagemenetsystem.dtos;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuditDTO {
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private UserDTO assignedBy;
    private UserDTO assignedTo;
    private DepartmentDTO department;
}
