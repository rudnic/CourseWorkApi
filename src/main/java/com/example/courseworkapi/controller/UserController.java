package com.example.courseworkapi.controller;

import com.example.courseworkapi.dto.ProfileDTO;
import com.example.courseworkapi.models.*;
import com.example.courseworkapi.repository.ObjectsRepository;
import com.example.courseworkapi.repository.RatingRepository;
import com.example.courseworkapi.repository.ReviewRepository;
import com.example.courseworkapi.repository.UserRepository;
import com.example.courseworkapi.security.jwt.JwtProvider;
import com.example.courseworkapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://itr-course-work-client.herokuapp.com"})
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable(name = "id") Long id) {

        Optional<User> optUser = userService.findById(id);

        if (!optUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProfileDTO profileDTO = new ProfileDTO(optUser.get());

        return new ResponseEntity<>(profileDTO, HttpStatus.OK);

    }

}
