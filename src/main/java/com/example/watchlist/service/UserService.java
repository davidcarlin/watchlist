package com.example.watchlist.service;

import com.example.watchlist.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User saveUser(User user);

    User getUserById(Long id);

    User updateUserById(Long id, User user);

    void deleteUserById(Long id);

    User findByUsername(String name);

    User createUser(String username, String password);

}
