package com.example.courseworkapi.repository;

import com.example.courseworkapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "insert into users_rating values (?1, ?2, ?3)", nativeQuery = true)
    public void rateObject(@Param("user_id") Long user_id,
                           @Param("object_id") Long object_id,
                           @Param("rating") int rating);
}
