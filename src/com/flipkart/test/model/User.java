package com.flipkart.test.model;

public class User {
    private String name;
    private UserLevel level;
    private int reviewCount;

    public User(String name) {
        this.name = name;
        this.level = UserLevel.VIEWER;
        this.reviewCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", reviewCount=" + reviewCount +
                '}';
    }
}
