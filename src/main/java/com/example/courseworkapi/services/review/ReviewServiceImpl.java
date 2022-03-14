package com.example.courseworkapi.services.review;

import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }
}
