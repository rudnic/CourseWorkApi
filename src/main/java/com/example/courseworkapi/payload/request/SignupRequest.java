package com.example.courseworkapi.payload.request;

import com.example.courseworkapi.models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class SignupRequest {
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
