package com.prototype.auditmanagemenetsystem.services;

import com.prototype.auditmanagemenetsystem.dtos.DepartmentDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;

import java.util.List;

public interface DepartmentService {
    ResponseDTO<List<DepartmentDTO>> getDepartments();
}
