package com.example.watchlist;

import com.example.watchlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreationConfig {

    private final UserService userService;

    @Autowired
    public UserCreationConfig(UserService userService) {
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createUser() {
        userService.createUser("gude", "password1");
    }
}
