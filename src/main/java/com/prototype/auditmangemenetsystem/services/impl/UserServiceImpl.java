package com.prototype.auditmangemenetsystem.services.impl;

import com.prototype.auditmangemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmangemenetsystem.dtos.UserDTO;
import com.prototype.auditmangemenetsystem.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResponseDTO<UserDTO> login(UserDTO userDTO) {
        return null;
    }
}
