package com.example.courseworkapi.services.rating;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Rating;
import com.example.courseworkapi.models.User;
import com.example.courseworkapi.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void addRating(User user, Objects object, float rating) {
        if (ratingRepository.findByUserAndObject(user, object) == null) {
                ratingRepository.save(new Rating(user, object, rating));
        }
        else {
            ratingRepository.updateRating(user, object, rating);
        }
    }

}
