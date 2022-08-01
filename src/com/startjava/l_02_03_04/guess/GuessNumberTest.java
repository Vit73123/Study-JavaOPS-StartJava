package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {

        Player[] players = addPlayers(3);
        GuessNumber game = new GuessNumber(players);

        String yesNo = "да";
        while (!yesNo.equals("нет")) {
            if (yesNo.equals(("да"))) {
                game.run();
                System.out.println();
            }
            System.out.print("Новая игра [да/нет]? ");
            Scanner scan = new Scanner(System.in, "windows-1251");  // Консоль в IntelliJ IDE
            yesNo = scan.nextLine();
        }
    }

    private static Player[] addPlayers(int countPlayers) {
        Player[] players = new Player[countPlayers];
        for (int i = 0; i < countPlayers; i++) {
            Scanner scan = new Scanner(System.in, "windows-1251");  // Консоль в IntelliJ IDE
            System.out.print("Введите имя игрока " + (i + 1) + ": ");
            players[i] = new Player(scan.nextLine());
        }
        return players;
    }
}