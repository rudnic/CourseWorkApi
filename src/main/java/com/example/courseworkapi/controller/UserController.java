package com.example.courseworkapi.controller;

import com.example.courseworkapi.dto.ProfileDTO;
import com.example.courseworkapi.models.*;
import com.example.courseworkapi.payload.request.AddPhotoRequest;
import com.example.courseworkapi.repository.*;
import com.example.courseworkapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://itr-course-work-client.herokuapp.com"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserPhotoRepository userPhotoRepository;


    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable(name = "id") Long id) {

        Optional<User> optUser = userService.findById(id);

        if (!optUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProfileDTO profileDTO = new ProfileDTO(optUser.get());

        return new ResponseEntity<>(profileDTO, HttpStatus.OK);

    }

    @PostMapping("/add-photo")
    public ResponseEntity<?> addUserPhoto(@RequestBody AddPhotoRequest addPhotoRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        for(int i = 0; i < addPhotoRequest.getCount(); i++) {
            UserPhoto userPhoto = new UserPhoto();
            userPhoto.setUser(user);
            userPhoto.setUuid(addPhotoRequest.getUuid() + "/nth/" + i + "/");
            userPhotoRepository.save(userPhoto);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
