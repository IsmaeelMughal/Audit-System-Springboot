package com.prototype.auditmanagemenetsystem.controllers;


import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.dtos.UserDTO;
import com.prototype.auditmanagemenetsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    ResponseDTO<List<UserDTO>> getAllAuditors ()
    {
        ResponseDTO<List<UserDTO>> responseDTO = new ResponseDTO<>();
        try {
            responseDTO = userService.getAllAuditors();
            responseDTO.setStatus(HttpStatus.OK);
        }
        catch (Exception e) {
            log.error("Exception occurred while getting all the users of role auditor");
            responseDTO.setData(null);
            responseDTO.setStatus(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Exception occured while getting all auditors");
        }

        return responseDTO;
    }
}