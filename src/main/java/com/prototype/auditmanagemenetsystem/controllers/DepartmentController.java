package com.prototype.auditmanagemenetsystem.controllers;

import com.prototype.auditmanagemenetsystem.dtos.DepartmentDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/all")
    ResponseDTO<List<DepartmentDTO>> getAllDepartments ()
    {
        ResponseDTO<List<DepartmentDTO>> responseDTO = new ResponseDTO<>();
        try {
            responseDTO = departmentService.getDepartments();
            responseDTO.setStatus(HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("Exception occurred while getting all communities");
            responseDTO.setData(null);
            responseDTO.setStatus(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Exception occured while getting all communities");
        }
        return responseDTO;
    }
}