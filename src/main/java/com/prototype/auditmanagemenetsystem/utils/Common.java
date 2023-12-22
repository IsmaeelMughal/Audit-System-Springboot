package com.prototype.auditmanagemenetsystem.utils;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.DepartmentDTO;
import com.prototype.auditmanagemenetsystem.dtos.UserDTO;
import com.prototype.auditmanagemenetsystem.models.AuditEntity;
import com.prototype.auditmanagemenetsystem.models.DepartmentEntity;
import com.prototype.auditmanagemenetsystem.models.UserEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Common {

    public static final List<String> CORS_ALLOWED_ORIGINS = List.of("http://127.0.0.1:3000", "http://localhost:3000");
    public static final List<String> CORS_ALLOWED_HEADERS = Arrays.asList(
            "Origin", "Access-Control-Allow-Origin", "Content-Type",
            "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
            "Access-Control-Request-Method", "Access-Control-Request-Headers");
    public static final List<String> CORS_EXPOSED_HEADERS =Arrays.asList(
            "Origin", "Content-Type", "Accept", "Authorization",
            "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
    public static final List<String> CORS_ALLOWED_METHODS =Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH");
    public static final String CORS_CONFIGURATION_PATTERN = "/**";


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
