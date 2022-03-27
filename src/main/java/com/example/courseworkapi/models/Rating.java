package com.example.courseworkapi.models;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "user_ratings")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Data
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "object_id")
    private Objects object;

    private float rating;

    public Rating(User user, Objects object, float rating) {
        this.user = user;
        this.object = object;
        this.rating = rating;
    }
}
