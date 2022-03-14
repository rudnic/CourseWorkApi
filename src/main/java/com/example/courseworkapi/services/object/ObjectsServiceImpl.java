package com.example.courseworkapi.services.object;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.repository.ObjectsRepository;
import com.example.courseworkapi.repository.ReviewRepository;
import com.example.courseworkapi.services.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectsServiceImpl implements ObjectsService {

    @Autowired
    private ObjectsRepository objectsRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Optional<Objects> findById(Long id) {
        return objectsRepository.findById(id);
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Objects> findAll() {
        return objectsRepository.findAll();
    }

    @Override
    public List<Objects> findByType(String type) {
        return objectsRepository.findByType(type);
    }

    @Override
    public Objects getById(Long id) {
        return objectsRepository.getById(id);
    }

    @Override
    public void save(Objects objects) {
        objectsRepository.save(objects);
    }
}
