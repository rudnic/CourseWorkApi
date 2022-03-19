package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Review;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewObjectDTO implements Serializable {
    private UserListDTO userListDTO;
    private String text;

    public ReviewObjectDTO(Review review) {
        this.text = review.getText();
        this.userListDTO = new UserListDTO(review.getUser());
    }
}
