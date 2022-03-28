package com.example.courseworkapi.repository;

import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Rating;
import com.example.courseworkapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByUserAndObject(User user, Objects object);


    @Modifying
    @Transactional
    @Query(value = "update Rating r set r.rating = :rating where r.user = :user and r.object = :object")
    void updateRating(@Param("user") User user, @Param("object") Objects object, @Param("rating") float rating);
}
