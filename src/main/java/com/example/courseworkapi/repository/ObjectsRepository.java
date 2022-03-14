package com.example.courseworkapi.repository;

import com.example.courseworkapi.models.Objects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectsRepository extends JpaRepository<Objects, Long> {
    public List<Objects> findByType(String type);
}
