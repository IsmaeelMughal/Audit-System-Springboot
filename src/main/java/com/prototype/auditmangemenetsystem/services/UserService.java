package com.prototype.auditmangemenetsystem.services;

import com.prototype.auditmangemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmangemenetsystem.dtos.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    ResponseDTO<UserDTO> register(UserDTO userDTO);
}
