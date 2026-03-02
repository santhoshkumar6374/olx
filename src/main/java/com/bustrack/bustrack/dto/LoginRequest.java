package com.bustrack.bustrack.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    // getters and setters
}
