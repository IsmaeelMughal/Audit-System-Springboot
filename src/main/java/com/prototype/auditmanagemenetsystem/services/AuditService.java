package com.prototype.auditmanagemenetsystem.services;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;

import java.util.List;

public interface AuditService {
    ResponseDTO<List<AuditDTO>> getAllAudits();
}
