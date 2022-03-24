package com.example.courseworkapi.controller;

import com.example.courseworkapi.models.ENRoles;
import com.example.courseworkapi.models.User;
import com.example.courseworkapi.payload.request.LoginRequest;
import com.example.courseworkapi.payload.request.SignupRequest;
import com.example.courseworkapi.payload.response.JwtResponse;
import com.example.courseworkapi.payload.response.MessageResponse;
import com.example.courseworkapi.repository.RoleRepository;
import com.example.courseworkapi.security.jwt.JwtProvider;
import com.example.courseworkapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:4200", "https://itr-course-work-client.herokuapp.com"})
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String jwt = jwtProvider.generateAccessToken(loginRequest.getUsername());
        User user = (User) userService.loadUserByUsername(loginRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt,
                user.getId(),
                user.getEmail(),
                user.getRole()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registrationUser(@RequestBody SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setFirstname(signupRequest.getFirstname());
        user.setLastname(signupRequest.getLastname());
        user.setRole(ENRoles.ROLE_USER);

        userService.saveUser(user);
        return new ResponseEntity<>(new MessageResponse("User registered successfully!"), HttpStatus.OK);
    }

    @GetMapping("/secret")
    public ResponseEntity<?> secretPage() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
