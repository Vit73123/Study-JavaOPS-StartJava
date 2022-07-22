package com.startjava.l_02_03_04.guess;

import java.util.Arrays;

class Player {
    private final String name;
    private int[] numbs;
    private int currentAttempt = 0;

    public Player(String name) {
        this.name = "\'" + name + "\'";
    }

    public String getName() {
        return name;
    }

    public int[] getNumbs() {
        return Arrays.copyOf(numbs, currentAttempt);
    }

    public void setNumbs(int num) {
        numbs = new int[num];
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void cleanNumbers() {
        if (currentAttempt > 0) {
            Arrays.fill(numbs, 0, currentAttempt, 0);
            currentAttempt = 0;
        }
    }

    public void addNum (int num) {
        numbs[currentAttempt++] = num;
    }
}