package com.varunslearnings.reactiveprogramming.service;

import com.varunslearnings.reactiveprogramming.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public User getUserInfo(int userId) {
        return User.builder().id(userId).name("varun").build();
    }
}
