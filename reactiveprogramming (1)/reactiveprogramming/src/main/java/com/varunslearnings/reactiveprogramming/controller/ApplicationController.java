package com.varunslearnings.reactiveprogramming.controller;

import com.varunslearnings.reactiveprogramming.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.varunslearnings.reactiveprogramming.service.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ApplicationController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserPreferenceService userPreferenceService;

    @GetMapping("/hello/{userId}")
    public User sayHello(@PathVariable("userId") int userId) {
        //Io blocking , idling threads
        User getUserInfo = userService.getUserInfo(userId);
        String userPreference = userPreferenceService.getUserPreference(userId);
        getUserInfo.setPreference(userPreference);
        return getUserInfo;

        //concurrency api
//        CompletableFuture<User> userInfo = CompletableFuture.supplyAsync(() -> userService.getUserInfo(userId));
//        CompletableFuture<String> userPref = CompletableFuture.supplyAsync(() -> userPreferenceService.getUserPreference(userId));
//        CompletableFuture<Void> allJoin = CompletableFuture.allOf(userInfo,userPref);
//        allJoin.join();
//        var user = userInfo.join();
//        var userPreference = userPref.join();
//        user.setPreference(userPreference);
//        return user;
    }
}
