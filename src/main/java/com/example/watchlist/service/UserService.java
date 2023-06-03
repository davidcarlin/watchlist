package com.example.watchlist.service;

import com.example.watchlist.entity.User;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);

    User updateUserById(Long id, User user);

    void deleteUserById(Long id);
}
