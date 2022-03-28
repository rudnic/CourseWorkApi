package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewProfileDTO implements Serializable {

    private ObjectsListDTO object;
    private String header;
    private String text;
    private String type;

    public ReviewProfileDTO(Review review) {
        this.text = review.getText();
        this.header = review.getHeader();
        this.type = review.getType();
        this.object = new ObjectsListDTO(review.getObject());
    }
}
