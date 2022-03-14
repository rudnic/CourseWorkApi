package com.example.courseworkapi.dto;
import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO implements Serializable{
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private List<Review> reviews;
}
