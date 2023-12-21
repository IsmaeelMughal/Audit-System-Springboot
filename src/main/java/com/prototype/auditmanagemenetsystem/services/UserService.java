package com.prototype.auditmanagemenetsystem.services;

import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.dtos.UserDTO;

import java.util.List;

public interface UserService {
    ResponseDTO<UserDTO> login(UserDTO userDTO);
    ResponseDTO<List<UserDTO>> getAllAuditors();
}
