package com.startjava.l_02_03_04.guess;

import java.util.Arrays;

class Player {
    private final String name;
    private int[] nums;
    private int attempt;
    private int score;

    public Player(String name) {
        this.name = "\'" + name + "\'";
    }

    public String getName() {
        return name;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, attempt);
    }

    public int getAttempt() {
        return attempt;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUp(int countAttempts) {
        attempt = 0;
        this.nums = new int[countAttempts];
    }

    public void clearNums() {
        if (attempt > 0) {
            Arrays.fill(nums, 0, attempt, 0);
            attempt = 0;
        }
    }

    public void addNum(int num, int startRange, int endRange) throws IllegalArgumentException {
        if ((num < startRange) || (num > endRange)) {
            throw new IllegalArgumentException("\'" + num + "\' - недопустимое число, должно быть от 1 до 100");
        }
        nums[attempt++] = num;
    }

    public void addWin() {
        score++;
    }
}