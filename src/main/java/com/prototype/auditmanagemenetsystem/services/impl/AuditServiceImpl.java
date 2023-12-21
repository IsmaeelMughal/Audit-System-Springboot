package com.prototype.auditmanagemenetsystem.services.impl;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.models.AuditEntity;
import com.prototype.auditmanagemenetsystem.respositories.AuditRepository;
import com.prototype.auditmanagemenetsystem.services.AuditService;
import com.prototype.auditmanagemenetsystem.utils.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    @Override
    public ResponseDTO<List<AuditDTO>> getAllAudits() {
        List<AuditEntity> auditEntities = auditRepository.findAll();

        List<AuditDTO> auditDTOS = auditEntities.stream().map(
                Common::convertAuditEntityToAuditDTO
        ).toList();
        return new ResponseDTO<>(auditDTOS, HttpStatus.OK, "List of All Audits!!!");
    }
}
