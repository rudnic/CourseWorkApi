package com.example.courseworkapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "objects")
@NoArgsConstructor
public class Objects implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String name;
    private String picture;

    @OneToMany(mappedBy = "object")
    @JsonBackReference
    private List<Review> review;

    public boolean addReview(Review review) {
        this.review.add(review);
        return true;
    }

}
