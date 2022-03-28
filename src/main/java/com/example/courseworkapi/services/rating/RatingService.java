package com.example.courseworkapi.services.rating;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.User;

public interface RatingService {
    void addRating(User user, Objects object, float rating);
}
