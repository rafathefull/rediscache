package com.example.demo.persistence.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // Si no vienen todos los campos, no fallará la serialización.
public class UserDTO implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String email;

    public UserDTO() {
    }
}
