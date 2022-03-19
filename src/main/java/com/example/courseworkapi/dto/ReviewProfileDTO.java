package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewProfileDTO implements Serializable {

    private ObjectsListDTO objectDTO;

    private String text;

    public ReviewProfileDTO(Review review) {
        this.text = review.getText();
        this.objectDTO = new ObjectsListDTO(review.getObject());
    }
}
