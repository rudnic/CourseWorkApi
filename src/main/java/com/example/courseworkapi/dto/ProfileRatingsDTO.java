package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Rating;
import com.example.courseworkapi.models.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRatingsDTO implements Serializable {

    private ObjectsListDTO objectDTO;

    private float rating;

    public ProfileRatingsDTO(Rating rating) {
        this.objectDTO = new ObjectsListDTO(rating.getObject());
        this.rating = rating.getRating();
    }
}
