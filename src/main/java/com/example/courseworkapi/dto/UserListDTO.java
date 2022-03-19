package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserListDTO implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    public UserListDTO(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
    }
}
