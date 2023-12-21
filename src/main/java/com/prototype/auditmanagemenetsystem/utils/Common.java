package com.prototype.auditmanagemenetsystem.utils;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.DepartmentDTO;
import com.prototype.auditmanagemenetsystem.dtos.UserDTO;
import com.prototype.auditmanagemenetsystem.models.AuditEntity;
import com.prototype.auditmanagemenetsystem.models.DepartmentEntity;
import com.prototype.auditmanagemenetsystem.models.UserEntity;

import java.time.LocalDate;

public class Common {

    public static UserDTO convertUserEntityToUserDTO(UserEntity userEntity){
        return UserDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .role(userEntity.getRole().getName())
                .build();
    }

    public static DepartmentDTO convertDepartmentEntityToDepartmentDTO(DepartmentEntity departmentEntity){
        return DepartmentDTO.builder()
                .id(departmentEntity.getId())
                .name(departmentEntity.getName())
                .build();
    }

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private UserDTO assignedBy;
    private UserDTO assignedTo;
    private DepartmentDTO department;

    public static AuditDTO convertAuditEntityToAuditDTO(AuditEntity auditEntity){
        return AuditDTO.builder()
                .id(auditEntity.getId())
                .startDate(auditEntity.getStartDate())
                .endDate(auditEntity.getEndDate())
                .status(auditEntity.getStatus())
                .assignedBy(convertUserEntityToUserDTO(auditEntity.getAssignedBy()))
                .assignedTo(convertUserEntityToUserDTO(auditEntity.getAssignedTo()))
                .department(convertDepartmentEntityToDepartmentDTO(auditEntity.getDepartment()))
                .build();
    }
}
