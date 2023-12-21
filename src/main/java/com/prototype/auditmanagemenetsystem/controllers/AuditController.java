package com.prototype.auditmanagemenetsystem.controllers;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.services.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audits")
@Slf4j
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    public ResponseDTO<List<AuditDTO>> getAllAudits(){
        return auditService.getAllAudits();
    }

    @PostMapping("/add")
    public ResponseDTO<AuditDTO> addAudit(@RequestBody AuditDTO auditDto)
    {
        ResponseDTO<AuditDTO> responseDTO = new ResponseDTO<>();
        try {
            responseDTO = auditService.addAudit(auditDto);
        } catch (Exception e) {
            log.error("Exception occured while adding resident " + e.getLocalizedMessage());
        }

        return responseDTO;
    }
}
