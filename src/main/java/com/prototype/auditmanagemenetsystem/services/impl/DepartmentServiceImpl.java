package com.prototype.auditmanagemenetsystem.services.impl;

import com.prototype.auditmanagemenetsystem.dtos.DepartmentDTO;
import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.models.DepartmentEntity;
import com.prototype.auditmanagemenetsystem.respositories.DepartmentRepository;
import com.prototype.auditmanagemenetsystem.services.DepartmentService;
import com.prototype.auditmanagemenetsystem.utils.Common;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public ResponseDTO<List<DepartmentDTO>> getDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        DepartmentDTO departmentDTO;
        ResponseDTO<List<DepartmentDTO>> responseDTO = new ResponseDTO<>();

        try {
            for (DepartmentEntity departmentEntity : departmentEntities)
            {
                departmentDTO = Common.convertDepartmentEntityToDepartmentDTO(departmentEntity);
                departmentDTOS.add(departmentDTO);
            }

            responseDTO.setData(departmentDTOS);
            responseDTO.setStatus(HttpStatus.OK);
            responseDTO.setMessage("Getting all the department data");
        } catch (Exception e) {
            log.error("Error while getting all the departments " + e.getLocalizedMessage());
            responseDTO.setStatus(HttpStatus.BAD_REQUEST);
        }

        return responseDTO;
    }

}
