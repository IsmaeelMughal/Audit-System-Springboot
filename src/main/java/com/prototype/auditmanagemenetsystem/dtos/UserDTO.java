package com.prototype.auditmanagemenetsystem.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String role;
}
