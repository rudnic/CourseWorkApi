package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Review;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ObjectDTO implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String picture;
    private List<Review> review;
}
