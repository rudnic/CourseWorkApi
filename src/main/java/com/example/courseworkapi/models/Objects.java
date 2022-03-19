package com.example.courseworkapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "objects")
@NoArgsConstructor
@ToString
public class Objects implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String name;
    private String picture;
    private String author;

    private float rating;

    @OneToMany(mappedBy = "object")
    //@JsonManagedReference
    private List<Rating> ratings;

    @OneToMany(mappedBy = "object")
    //@JsonBackReference
    private List<Review> review;

    public boolean addReview(Review review) {
        this.review.add(review);
        return true;
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

}
