package com.example.courseworkapi.controller;

import com.example.courseworkapi.dto.ObjectDTO;
import com.example.courseworkapi.dto.ObjectsListDTO;
import com.example.courseworkapi.models.Objects;
import com.example.courseworkapi.models.Rating;
import com.example.courseworkapi.models.Review;
import com.example.courseworkapi.models.User;
import com.example.courseworkapi.payload.request.AddReviewRequest;
import com.example.courseworkapi.payload.request.RateObjectRequest;
import com.example.courseworkapi.repository.RatingRepository;
import com.example.courseworkapi.repository.ReviewRepository;
import com.example.courseworkapi.repository.UserRepository;
import com.example.courseworkapi.services.object.ObjectsService;
import com.example.courseworkapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectsController {

    @Autowired
    private ObjectsService objectsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/object/{id}")
    public ResponseEntity<?> getObject(@PathVariable(name = "id") Long id) {

        Optional<Objects> obj = objectsService.findById(id);

        if (!obj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ObjectDTO objectDTO = new ObjectDTO(obj.get());
        return new ResponseEntity<>(objectDTO, HttpStatus.OK);
    }

    @GetMapping("/objects")
    public ResponseEntity<?> getAllObjects() {
        List<ObjectsListDTO>  objectsListDTO= objectsService.findAll().stream()
                .map(ObjectsListDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(objectsListDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/objects", params = {"type"})
    public ResponseEntity<?> getObjects(@RequestParam(value = "type") String type) {

        if (type.equals("all")) {
            List<ObjectsListDTO> objectsListDTO = objectsService.findAll().stream()
                    .map(ObjectsListDTO::new)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(objectsListDTO, HttpStatus.OK);
        }
        else {
            List<ObjectsListDTO> objectsListDTO = objectsService.findByType(type).stream()
                    .map(ObjectsListDTO::new)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(objectsListDTO, HttpStatus.OK);
        }

    }

    @PostMapping("/objects/{id}/add-review")
    public ResponseEntity<?> addReview(@RequestBody AddReviewRequest addReviewRequest,
                                       @PathVariable(name = "id") Long id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        Objects object = objectsService.getById(id);

        Review review = new Review();
        review.setObject(object);
        review.setUser(user);
        review.setType(addReviewRequest.getType());
        review.setHeader(addReviewRequest.getHeader());
        review.setText(addReviewRequest.getText());

        objectsService.addReview(review);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/objects/{id}/rate")
    public ResponseEntity<?> rateObject(@PathVariable(name = "id") Long id,
                                        @RequestBody RateObjectRequest rateObjectRequest) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        user = userRepository.getById(user.getId());

        ratingRepository.save(new Rating(user, objectsService.getById(id), rateObjectRequest.getRating()));

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
