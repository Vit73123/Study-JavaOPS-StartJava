package com.startjava.l_02_03_04.guess;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Player {
    private final String name;
    private int[] numbers;
    private int currentMove = 0;

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currentMove);
    }

    public void setNumbers(int num) {
        numbers = new int[num];
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public Player(String name) {
        this.name = "\'" + name + "\'";
    }

    public int giveNumber(int min, int max) {
        System.out.print(name + ", Ваше число? ");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                int number = scan.nextInt();
                if ((number < min) || (number > max)) {
                    throw new IllegalArgumentException("Недопустимое число");
                }
                numbers[currentMove++] = number;
                return number;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.print(name + ", пожалуйста, введите ЦЕЛОЕ ЧИСЛО от " + min + " до " + max + ": ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" У игрока " + name + " превышено число попыток");
            }
        }
    }

    public void cleanNumbers() {
        if (currentMove > 0) {
            Arrays.fill(numbers, 0,  currentMove, 0);
            currentMove = 0;
        }
    }

    public void printNumbers() {
        System.out.print("Числа игрока " + name + ": ");
        for (int num : getNumbers()) {
            System.out.printf("%3d", num);
        }
        System.out.println();
    }
}