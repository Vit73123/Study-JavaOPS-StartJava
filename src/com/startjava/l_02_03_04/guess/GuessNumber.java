package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

public class GuessNumber {

    private final int startRange = 1;
    private final int endRange = 100;
    private int targetNumber;
    private final int countAttempts = 10;
    private final int countGames = 3;
    private int recordScore;
    private final Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
        for (Player player : players) { player.setUp(countAttempts); }
        System.out.println("У каждого игрока по " + countAttempts + " попыток. Играем " + countGames + " игры.");
    }

    private void setUpPlay() {
        recordScore = 0;
        for (Player player : players) { player.setScore(0); }
    }

    public void play() {
        setUpPlay();
        for (int i = 0; i < countGames; i++) { playGame(); }
        System.out.println();
        printResult();
    }

    private void setUpGame() {
        for (Player player : players) { player.clearNums(); }
    }

    private void playGame() {
        setUpGame();
        Scanner scan = new Scanner(System.in, "windows-1251");

        targetNumber = startRange + (int) (Math.random() * endRange);
        System.out.print('\n' + "*".repeat(60) + "\n\n");
        int numAttempt = 0;
        int numTurn = 0;
        int[] turn = new int[players.length];
        for (int i = 0; i < players.length; i++) turn[i] = i;
        while (numAttempt < countAttempts) {
            if (numTurn == players.length) {
                numAttempt++;
                numTurn = 0;
                System.out.println("Осталось: " + (countAttempts - numAttempt) + " попыток\n");
            }
            if (numTurn == 0) {
                shuffleTurn(turn);
                printTurn(turn);
                System.out.println();
            }
            if (isGuessed(players[turn[numTurn]])) break;
            numTurn++;
        }
        printNumbers();
    }

    private boolean isGuessed(Player player) {
        try {
            int num = guess(player);
            boolean result = (num == targetNumber);
            if (result) {
                int score = player.getScore();
                if (score++ == recordScore) recordScore++;
                player.setScore(score);
                System.out.println('\n' + player.getName() + ", Вы угадали c " + player.getAttempt() + " попытки!");
            } else {
                System.out.println(("Число " + num + (num < targetNumber ? " меньше " : " больше ") +
                        "того, что загадал компьютер"));
            }
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Вы ошиблись: " + e.getMessage() + ". Ход переходит к следующему игроку");
            return false;
        }
    }

    private int guess(Player player) throws IllegalArgumentException {
        System.out.print(player.getName() + ", Ваше число? ");
        Scanner scan = new Scanner(System.in);
        String numString = scan.next();
        try {
            int num = Integer.parseInt(numString);
            player.addNum(num, startRange, endRange);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("\'" + numString + "\' не является целым числом");
        }
    }

    private void shuffleTurn(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int num = (int) (i + Math.random() * (nums.length - 1));
            int tmp = nums[i];
            nums[i] = nums[num];
            nums[num] = tmp;
        }
    }

    private boolean isDraw() {
        int countRecords = 0;
        for (Player player : players) {
            if (player.getScore() == recordScore) {
                if (countRecords++ > 0) { return true; }
            }
        }
        return false;
    }

    private void printTurn(int[] turn) {
        System.out.println("Бросаем жребий...\nОчерёдность игроков:");
        for (int i = 0; i < players.length; i++) {
            System.out.println((i + 1) + " - " + players[turn[i]].getName());
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
            if (player.getScore() == recordScore) {
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