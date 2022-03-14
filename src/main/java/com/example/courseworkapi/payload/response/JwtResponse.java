package com.example.courseworkapi.payload.response;

import com.example.courseworkapi.models.ENRoles;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private final String type = "Bearer";
    private Long id;
    private String email;
    private ENRoles role;
}
