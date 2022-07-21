package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

public class GuessNumber {

    private final int min = 1;
    private final int max = 100;
    private int targetNumber;
    private final int maxMoves = 10;
    private final Player player1;
    private final Player player2;

    public int getMaxMoves() {
        return maxMoves;
    }

    public GuessNumber (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        player1.setNumbers(maxMoves);
        player2.setNumbers(maxMoves);
    }

    public void play() {
        Scanner scan = new Scanner(System.in, "windows-1251");
        player1.cleanNumbers();
        player2.cleanNumbers();

        targetNumber = min + (int) (Math.random() * max);
        int currentMove = 1;
        System.out.println("************************************************************");
        while ((currentMove < maxMoves) && !(isGuessed(player1) || isGuessed(player2))) {
            System.out.println("Осталось: " + (maxMoves - currentMove) + " попыток\n");
            currentMove++;
        }
        player1.printNumbers();
        player2.printNumbers();
    }

    private boolean isGuessed(Player player) {
        int number = player.giveNumber(min, max);
        if (number < targetNumber) {
            System.out.println("Число " + number +
                    " меньше того, что загадал компьютер");
        } else if (number > targetNumber) {
            System.out.println("Число " + number +
                    " больше того, что загадал компьютер");
        } else {
            System.out.println(player.getName() + ", Вы угадали c " + player.getCurrentMove() + " попытки!");
            return true;
        }
        return false;
    }
}