package com.prototype.auditmanagemenetsystem.services.impl;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.models.AuditEntity;
import com.prototype.auditmanagemenetsystem.models.DepartmentEntity;
import com.prototype.auditmanagemenetsystem.models.UserEntity;
import com.prototype.auditmanagemenetsystem.respositories.AuditRepository;
import com.prototype.auditmanagemenetsystem.respositories.DepartmentRepository;
import com.prototype.auditmanagemenetsystem.respositories.UserRepository;
import com.prototype.auditmanagemenetsystem.services.AuditService;
import com.prototype.auditmanagemenetsystem.utils.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    @Override
    public ResponseDTO<List<AuditDTO>> getAllAudits() {
        List<AuditEntity> auditEntities = auditRepository.findAll();

        List<AuditDTO> auditDTOS = auditEntities.stream().map(
                Common::convertAuditEntityToAuditDTO
        ).toList();
        return new ResponseDTO<>(auditDTOS, HttpStatus.OK, "List of All Audits!!!");
    }

    @Transactional
    @Override
    public ResponseDTO<AuditDTO> addAudit(AuditDTO auditDTO) {
        UserEntity assignedByEntity = userRepository.getReferenceById(auditDTO.getAssignedBy().getId());
        UserEntity assignedToEntity = userRepository.getReferenceById(auditDTO.getAssignedTo().getId());

        DepartmentEntity departmentEntity = departmentRepository.getReferenceById(auditDTO.getDepartment().getId());

        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setStartDate(auditDTO.getStartDate());
        auditEntity.setEndDate(auditDTO.getEndDate());
        auditEntity.setStatus(auditDTO.getStatus());
        auditEntity.setAssignedBy(assignedByEntity);
        auditEntity.setAssignedTo(assignedToEntity);
        auditEntity.setDepartment(departmentEntity);

        AuditEntity auditResponse = auditRepository.save(auditEntity);

        AuditDTO auditDTOResponse = Common.convertAuditEntityToAuditDTO(auditResponse);

        ResponseDTO<AuditDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(auditDTOResponse);
        responseDTO.setStatus(HttpStatus.OK);
        responseDTO.setMessage("Audit added successfully");

        return responseDTO;
    }

}
