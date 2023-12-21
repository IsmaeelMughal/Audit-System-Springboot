package com.prototype.auditmangemenetsystem.services.impl;

import com.prototype.auditmangemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmangemenetsystem.dtos.UserDTO;
import com.prototype.auditmangemenetsystem.models.UserEntity;
import com.prototype.auditmangemenetsystem.respositories.UserRepository;
import com.prototype.auditmangemenetsystem.services.UserService;
import com.prototype.auditmangemenetsystem.utils.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public ResponseDTO<UserDTO> login(UserDTO userDTO) {
        if(userDTO.getEmail() == null || userDTO.getPassword() == null){
            return new ResponseDTO<>(null, HttpStatus.BAD_REQUEST, "Email or Password cannot be null");
        }
        Optional<UserEntity> optionalUser = userRepository
                .findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        if(optionalUser.isEmpty()){
            return new ResponseDTO<>(null, HttpStatus.NOT_FOUND, "Invalid Credentials!!!!");
        }
        UserDTO loggedInUser = Common.convertUserEntityToUserDTO(optionalUser.get());
        return new ResponseDTO<>(loggedInUser, HttpStatus.OK, "Logged In Successfully!!!");
    }
}
