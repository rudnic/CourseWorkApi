package com.example.courseworkapi.controller;

import com.example.courseworkapi.dto.ProfileDTO;
import com.example.courseworkapi.models.EObjectType;
import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.models.User;
import com.example.courseworkapi.repository.ObjectsRepository;
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
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ObjectsRepository objectsRepository;

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable(name = "id") Long id) {

        Optional<User> optUser = userService.findById(id);

        if (!optUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setId(optUser.get().getId());
        profileDTO.setEmail(optUser.get().getEmail());
        profileDTO.setReviews(optUser.get().getReviews());
        profileDTO.setFirstname(optUser.get().getFirstname());
        profileDTO.setLastname(optUser.get().getLastname());

        return new ResponseEntity<>(profileDTO, HttpStatus.OK);

    }

    @PostMapping("/add-review")
    public ResponseEntity<?> addReview() {

        // How to save and create review //
        /*reviewRepository.save(new Review(userService.getUserById(Long.valueOf(7)),
                objectsRepository.findById(Long.valueOf(9)).get(), "BOOK", "Wooow!")); */

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
