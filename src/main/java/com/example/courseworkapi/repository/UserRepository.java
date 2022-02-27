package com.example.courseworkapi.repository;

import com.example.courseworkapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getByEmail(String email);
}
