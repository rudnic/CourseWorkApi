package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Review;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewObjectDTO implements Serializable {
    private UserListDTO user;
    private String header;
    private String type;
    private String text;

    public ReviewObjectDTO(Review review) {
        this.text = review.getText();
        this.type = review.getType();
        this.header = review.getHeader();
        this.user = new UserListDTO(review.getUser());
    }
}
