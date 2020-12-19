package com.paradox.geek.services;

import com.paradox.geek.model.User;
import com.paradox.geek.model.UserLevel;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> userMap;
    private static UserService INSTANCE;

    private UserService() {
        userMap = new HashMap<>();
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }

    public void addUser(String userName) {
        if (userMap.containsKey(userName)) {
            System.out.println("user already exists");
            return;
        }
        User user = new User(userName);
        userMap.put(userName, user);
        System.out.println("Added new user"+userName);
    }

    public User getUser(String username) {
        if (userMap.containsKey(username)) {
            return userMap.get(username);
        }
        return null;
    }

    public static void updateUserLevelIfEligible(User user) {
        int reviewCount = user.getReviewCount();
        UserLevel userLevel = user.getLevel();
        if (userLevel.getMaxCount() <= reviewCount) {
            user.setLevel(userLevel.getNextLevel());
        }
    }
}
