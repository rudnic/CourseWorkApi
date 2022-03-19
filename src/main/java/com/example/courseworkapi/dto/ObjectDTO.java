package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Rating;
import com.example.courseworkapi.models.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ObjectDTO implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String picture;
    private String author;
    private float rating;


    private List<ObjectRatingsDTO> ratings;
    private List<ReviewObjectDTO> reviews;

    public ObjectDTO(Objects object) {
        this.id = object.getId();
        this.name = object.getName();
        this.type = object.getType();
        this.picture = object.getPicture();
        this.author = object.getAuthor();
        this.rating = object.getRating();
        this.ratings = object.getRatings().stream()
                .map(ObjectRatingsDTO::new)
                .collect(Collectors.toList());
        this.reviews = object.getReview().stream()
                .map(ReviewObjectDTO::new)
                .collect(Collectors.toList());
    }
}
