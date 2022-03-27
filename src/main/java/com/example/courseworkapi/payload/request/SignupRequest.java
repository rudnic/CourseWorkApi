package com.example.courseworkapi.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupRequest {
    private String password;
    private String username;
    private String firstname;
    private String lastname;
}
