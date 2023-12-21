package com.prototype.auditmangemenetsystem.controllers;

import com.prototype.auditmangemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmangemenetsystem.dtos.UserDTO;
import com.prototype.auditmangemenetsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseDTO<UserDTO> login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }
}
