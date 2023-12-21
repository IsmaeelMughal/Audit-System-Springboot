package com.prototype.auditmanagemenetsystem.services;

import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.dtos.UserDTO;

public interface UserService {
    ResponseDTO<UserDTO> login(UserDTO userDTO);
}
