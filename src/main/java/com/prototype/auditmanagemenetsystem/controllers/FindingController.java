package com.prototype.auditmanagemenetsystem.controllers;


import com.prototype.auditmanagemenetsystem.dtos.FindingDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.services.FindingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/findings")
public class FindingController {

    private final FindingService findingService;
    @PostMapping
    public ResponseDTO<FindingDTO> addFinding(@RequestBody FindingDTO findingDTO){
        return findingService.addFinding(findingDTO);
    }
}
