package com.example.courseworkapi.dto;
import com.example.courseworkapi.models.User;
import com.example.courseworkapi.models.UserPhoto;
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
public class ProfileDTO implements Serializable{
    private Long id;
    private String email;
    private String firstname;
    private String lastname;

    private List<ProfileRatingsDTO> ratingsObjects;
    private List<ReviewProfileDTO> reviews;
    private List<UserPhoto> photos;

    public ProfileDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.ratingsObjects = user.getRatings().stream()
                .map(ProfileRatingsDTO::new)
                .collect(Collectors.toList());

        this.reviews = user.getReviews().stream()
                .map(ReviewProfileDTO::new)
                .collect(Collectors.toList());
        this.photos = user.getUserPhotos();
    }
}
