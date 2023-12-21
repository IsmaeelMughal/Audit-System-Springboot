package com.prototype.auditmanagemenetsystem.services.impl;

import com.prototype.auditmanagemenetsystem.dtos.FindingDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.models.AuditEntity;
import com.prototype.auditmanagemenetsystem.models.FindingEntity;
import com.prototype.auditmanagemenetsystem.respositories.AuditRepository;
import com.prototype.auditmanagemenetsystem.respositories.FindingRepository;
import com.prototype.auditmanagemenetsystem.services.FindingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindingServiceImpl implements FindingService {

    private final FindingRepository findingRepository;
    private final AuditRepository auditRepository;

    @Override
    public ResponseDTO<FindingDTO> addFinding(FindingDTO findingDTO) {
        if(findingDTO == null || findingDTO.getAuditId() == null){
            return new ResponseDTO<>(null, HttpStatus.BAD_REQUEST, "Finding or AuditId Cannot be null!!");
        }

        Optional<AuditEntity> optionalAuditEntity = auditRepository.findById(findingDTO.getAuditId());
        if(optionalAuditEntity.isEmpty()){
            return new ResponseDTO<>(null, HttpStatus.NOT_FOUND, "Audit does not exist!!");
        }

        FindingEntity findingEntity = new FindingEntity();
        findingEntity.setFormTitle(findingDTO.getFormTitle());
        findingEntity.setFindings(findingDTO.getFindings());
        findingEntity.setFindingRating(findingDTO.getFindingRating());
        findingEntity.setManagementComments(findingDTO.getManagementComments());
        findingEntity.setPostManagementComments(findingDTO.getPostManagementComments());
        findingEntity.setRisk(findingDTO.getRisk());
        findingEntity.setControlsInPlace(findingDTO.getControlsInPlace());
        findingEntity.setActionsRequired(findingDTO.getActionsRequired());
        findingEntity.setDeficiencies(findingDTO.getDeficiencies());
        findingEntity.setControlEffectiveness(findingDTO.getControlEffectiveness());
        findingEntity.setRecommendation(findingDTO.getRecommendation());
        findingEntity.setResponsibleDepartment(findingDTO.getResponsibleDepartment());
        findingEntity.setTimeline(findingDTO.getTimeline());
        findingEntity.setAudit(optionalAuditEntity.get());

        findingRepository.save(findingEntity);

        return new ResponseDTO<>(findingDTO, HttpStatus.OK, "Finding Added Successfully!!!");

    }
}
