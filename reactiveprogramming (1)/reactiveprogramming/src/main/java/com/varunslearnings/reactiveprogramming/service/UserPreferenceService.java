package com.varunslearnings.reactiveprogramming.service;

import com.varunslearnings.reactiveprogramming.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPreferenceService {
    public String getUserPreference(int userId) {
        return "Non-vegetarian";
    }
}
