package com.prototype.auditmanagemenetsystem.controllers;

import com.prototype.auditmanagemenetsystem.dtos.AuditDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.services.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audits")
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    public ResponseDTO<List<AuditDTO>> getAllAudits(){
        return auditService.getAllAudits();
    }

}
