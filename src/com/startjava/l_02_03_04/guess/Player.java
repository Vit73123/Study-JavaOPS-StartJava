package com.startjava.l_02_03_04.guess;

import java.util.Arrays;

class Player {
    private final String name;
    private int[] nums;
    private int currentAttempt = 0;

    public Player(String name) {
        this.name = "\'" + name + "\'";
    }

    public String getName() {
        return name;
    }

    public int[] getNums() {
        return Arrays.copyOf(nums, currentAttempt);
    }

    public void setNums(int num) {
        nums = new int[num];
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void cleanNumbers() {
        if (currentAttempt > 0) {
            Arrays.fill(nums, 0, currentAttempt, 0);
            currentAttempt = 0;
        }
    }

    public void addNum (int num) {
        nums[currentAttempt++] = num;
    }
}