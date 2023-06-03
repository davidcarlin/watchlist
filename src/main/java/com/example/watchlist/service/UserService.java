package com.example.watchlist.service;

import com.example.watchlist.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);

    User updateUserById(Long id, User user);

    void deleteUserById(Long id);

    User findByUsername(String name);
}
