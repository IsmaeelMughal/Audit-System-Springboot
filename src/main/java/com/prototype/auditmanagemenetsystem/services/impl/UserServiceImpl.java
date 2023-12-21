package com.prototype.auditmanagemenetsystem.services.impl;

import com.prototype.auditmanagemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmanagemenetsystem.dtos.UserDTO;
import com.prototype.auditmanagemenetsystem.models.RoleEntity;
import com.prototype.auditmanagemenetsystem.models.UserEntity;
import com.prototype.auditmanagemenetsystem.respositories.RoleRepository;
import com.prototype.auditmanagemenetsystem.respositories.UserRepository;
import com.prototype.auditmanagemenetsystem.services.UserService;
import com.prototype.auditmanagemenetsystem.utils.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
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


    @Override
    public ResponseDTO<List<UserDTO>> getAllAuditors() {
        RoleEntity roleEntity = roleRepository.getRoleEntityByName("AUDITOR");
        List<UserEntity> userEntities = userRepository.findByRole(roleEntity);
        List<UserDTO> userDTOS = new ArrayList<>();
        UserDTO userDTO;
        ResponseDTO<List<UserDTO>> responseDTO = new ResponseDTO<>();

        try {
            for(UserEntity userEntity : userEntities)
            {
                userDTO = Common.convertUserEntityToUserDTO(userEntity);
                userDTOS.add(userDTO);
            }

            responseDTO.setData(userDTOS);
            responseDTO.setStatus(HttpStatus.OK);
            responseDTO.setMessage("Getting all the users of role audit");
        }
        catch (Exception e) {
            responseDTO.setStatus(HttpStatus.BAD_REQUEST);
        }

        return responseDTO;
    }
}
