package com.startjava.l_02_03_04.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {

    private final int startRange = 1;
    private final int endRange = 100;
    private int targetNumber;
    private final int countAttempts = 10;
    private final Player player1;
    private final Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        player1.setNumbs(countAttempts);
        player2.setNumbs(countAttempts);
    }

    public int getCountAttempts() {
        return countAttempts;
    }

    public void play() {
        Scanner scan = new Scanner(System.in, "windows-1251");
        player1.cleanNumbers();
        player2.cleanNumbers();

        targetNumber = startRange + (int) (Math.random() * endRange);
        int currentAttempt = 1;
        System.out.print("*".repeat(60) + '\n');
        while ((currentAttempt < countAttempts) && !(isGuessed(player1) || isGuessed(player2))) {
            System.out.println("Осталось: " + (countAttempts - currentAttempt) + " попыток\n");
            currentAttempt++;
        }
        printNumbers(player1);
        printNumbers(player2);
    }

    private boolean isGuessed(Player player) {
        int number = guess(player);
        if (number < targetNumber) {
            System.out.println("Число " + number +
                    " меньше того, что загадал компьютер");
        } else if (number > targetNumber) {
            System.out.println("Число " + number +
                    " больше того, что загадал компьютер");
        } else {
            System.out.println(player.getName() + ", Вы угадали c " + player.getCurrentAttempt() + " попытки!");
            return true;
        }
        return false;
    }

    public int guess(Player player) {
        System.out.print(player.getName() + ", Ваше число? ");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int num = scan.nextInt();
                if ((num < startRange) || (num > endRange)) {
                    throw new IllegalArgumentException("Недопустимое число");
                }
                player.addNum(num);
                return num;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.print(player.getName() + ", пожалуйста, введите ЦЕЛОЕ ЧИСЛО от " + startRange + " до " + endRange + ": ");
            }
        }
    }

    public void printNumbers(Player player) {
        System.out.print("Числа игрока " + player.getName() + ": ");
        for (int num : player.getNumbs()) {
            System.out.printf("%3d", num);
        }
        System.out.println();
    }
}