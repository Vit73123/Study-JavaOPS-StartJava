package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {

        Player[] players = CreatePlayers(3);
        GuessNumber game = new GuessNumber(players);

        String yesNo = "да";
        Scanner scan = new Scanner(System.in, "windows-1251");  // Консоль в IntelliJ IDE
        while (!yesNo.equals("нет")) {
            if (yesNo.equals(("да"))) {
                game.run();
                System.out.println();
            }
            System.out.print("Новая игра [да/нет]? ");
            yesNo = scan.nextLine();
        }
    }

    private static Player[] CreatePlayers(int countPlayers) {
        Player[] players = new Player[countPlayers];
        Scanner scan = new Scanner(System.in, "windows-1251");  // Консоль в IntelliJ IDE
        for (int i = 0; i < countPlayers; i++) {
            System.out.print("Введите имя игрока " + (i + 1) + ": ");
            players[i] = new Player(scan.nextLine());
        }
        return players;
    }
}