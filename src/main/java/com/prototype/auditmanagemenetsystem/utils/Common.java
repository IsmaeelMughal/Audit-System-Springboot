package com.prototype.auditmanagemenetsystem.utils;

import com.prototype.auditmanagemenetsystem.dtos.UserDTO;
import com.prototype.auditmanagemenetsystem.models.UserEntity;

public class Common {

    public static UserDTO convertUserEntityToUserDTO(UserEntity userEntity){
        return UserDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .role(userEntity.getRole().getName())
                .build();
    }
}
