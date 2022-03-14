package com.example.courseworkapi.services.user;

import com.example.courseworkapi.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User getUserById(Long id);
    void saveUser(User user);
    Optional<User> findById(Long id);

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
