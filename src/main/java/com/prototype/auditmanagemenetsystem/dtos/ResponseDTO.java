package com.prototype.auditmanagemenetsystem.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDTO<T> {
    private T data;
    private HttpStatus status;
    private String message;
}
