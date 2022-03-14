package com.example.courseworkapi;

import com.example.courseworkapi.repository.ObjectsRepository;
import com.example.courseworkapi.repository.ReviewRepository;
import com.example.courseworkapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseWorkApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseWorkApiApplication.class, args);
    }

}
