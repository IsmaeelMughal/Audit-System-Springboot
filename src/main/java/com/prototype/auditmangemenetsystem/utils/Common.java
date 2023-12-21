package com.prototype.auditmangemenetsystem.utils;

import com.prototype.auditmangemenetsystem.dtos.UserDTO;
import com.prototype.auditmangemenetsystem.models.UserEntity;

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
