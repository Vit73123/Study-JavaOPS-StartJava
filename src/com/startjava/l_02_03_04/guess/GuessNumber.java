package com.startjava.l_02_03_04.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumber {

    public static final int startRange = 1;
    public static final int endRange = 100;
    private int targetNum;
    private final int countAttempts = 10;
    private final int countRounds = 3;
    private int maxScore;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
        for (Player player : players) player.setUp(countAttempts);
        System.out.println("У каждого игрока по " + countAttempts + " попыток. Играем " + countRounds + " игры.");
    }

    public void run() {
        setUpGame();
        for (int i = 0; i < countRounds; i++) runGameplay();
        System.out.println();
        printResult();
    }

    private void setUpGame() {
        maxScore = 0;
        for (Player player : players) player.setScore(0);
    }

    private void setUpRound() {
        for (Player player : players) player.clearNums();
    }

    private void runGameplay() {
        setUpRound();
        targetNum = startRange + (int) (Math.random() * endRange);
        System.out.print('\n' + "*".repeat(60) + "\n\n");
        int attempt = 0;
        int turn = 0;
        while (attempt < countAttempts) {
            if (turn == players.length) {
                attempt++;
                turn = 0;
                System.out.println("Осталось: " + (countAttempts - attempt) + " попыток\n");
            }
            if (turn == 0) {
                System.out.println("Бросаем жребий...\nОчерёдность игроков:");
                shuffleTurn();
                printTurn();
                System.out.println();
            }
            if (isGuessed(players[turn])) break;
            turn++;
        }
        printNumbers();
    }

    private boolean isGuessed(Player player) {
        int num;
        try {
            num = guess(player);
        } catch (IllegalArgumentException e) {
            System.out.println("Вы ошиблись: " + e.getMessage() + ". Ход переходит к следующему игроку");
            return false;
        }
        if (num == targetNum) {
            player.setScore(1);
            if (player.getScore() > maxScore) maxScore++;
            System.out.println('\n' + player.getName() + ", Вы угадали c " + player.getAttempt() + " попытки!");
            return true;
        } else {
            System.out.println(("Число " + num + (num < targetNum ? " меньше " : " больше ") +
                    "того, что загадал компьютер"));
            return false;
        }
    }

    private int guess(Player player) {
        int num = 0;
        try {
            System.out.print(player.getName() + ", Ваше число? ");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Не является целым числом");
        }
        player.addNum(num);
        return num;
    }

    private void shuffleTurn() {
        for (int i = 0; i < players.length - 1; i++) {
            int num = (int) (i + Math.random() * (players.length - 1));
            Player buffer = players[i];
            players[i] = players[num];
            players[num] = buffer;
        }
    }

    private boolean isDraw() {
        int countRecords = 0;
        for (Player player : players) {
            if (player.getScore() == maxScore) {
                if (countRecords++ > 0) { return true; }
            }
        }
        return false;
    }

    private void printTurn() {
        for (int i = 0; i < players.length; i++) {
            System.out.println((i + 1) + " - " + players[i].getName());
        }
    }

    private void printNumbers() {
        for (Player player : players) {
            System.out.print("Числа игрока " + player.getName() + ": ");
            for (int num : player.getNums()) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
    }

    private void printResult() {
        boolean draw = isDraw();
        String winners = "";
        String losers = "";
        for (Player player : players) {
            String tempString = player.getName() + " - " + player.getScore() + " ";
            if (player.getScore() == maxScore) {
                winners = winners + tempString;
            } else if (!draw) {
                losers = losers + tempString;
            }
        }
        if (draw) {
            System.out.println("Ничья: " + winners);
        } else {
            System.out.println("Победил: " + winners);
            System.out.println("Проигравшие: " + losers);
        }
    }
}