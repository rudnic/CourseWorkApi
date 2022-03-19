package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Rating;
import lombok.Data;

import java.io.Serializable;

@Data
public class ObjectRatingsDTO implements Serializable {

    private UserListDTO userListDTO;
    private float rating;

    public ObjectRatingsDTO(Rating rating) {
        this.userListDTO = new UserListDTO(rating.getUser());
        this.rating = rating.getRating();
    }
}
