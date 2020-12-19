package com.paradox.geek.model;

public enum UserLevel {
    VIEWER("viewer", 3, 1),
    CRITIC("critic", 6, 2),
    EXPERT("expert", 12, 3),
    ADMIN("admin", 24, 4)
    ;

    private String name;
    private int maxCount;
    private int weightage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }

    UserLevel(String name, int maxCount, int weightage) {
        this.name = name;
        this.maxCount = maxCount;
        this.weightage = weightage;
    }

    public UserLevel getNextLevel() {
        switch (this) {
            case VIEWER: return CRITIC;
            case CRITIC: return EXPERT;
            default: return ADMIN;
        }
    }
}
