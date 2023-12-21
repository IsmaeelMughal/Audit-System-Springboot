package com.prototype.auditmanagemenetsystem.services;

import com.prototype.auditmanagemenetsystem.dtos.FindingDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;

public interface FindingService {

    ResponseDTO<FindingDTO> addFinding(FindingDTO findingDTO);
}
