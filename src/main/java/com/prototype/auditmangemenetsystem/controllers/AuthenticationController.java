package com.prototype.auditmangemenetsystem.controllers;

import com.prototype.auditmangemenetsystem.dtos.ResponseDTO;
import com.prototype.auditmangemenetsystem.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final

    @PostMapping("/register")
    public ResponseDTO<UserDTO> register(@RequestBody UserDTO userDTO){
        return
    }
}
