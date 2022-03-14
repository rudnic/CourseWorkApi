package com.example.courseworkapi.services.object;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Review;

import java.util.List;
import java.util.Optional;

public interface ObjectsService {
    Optional<Objects> findById(Long id);
    public void addReview(Review review);
    public List<Objects> findAll();
    public List<Objects> findByType(String type);
    public Objects getById(Long id);
    public void save(Objects objects);
}
