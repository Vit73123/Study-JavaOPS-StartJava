package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251");  // Консоль в IntelliJ IDE

        Player[] players = new Player[3];
        for (int i = 0; i < players.length; i++) {
            System.out.print("Введите имя игрока " + (i + 1) + ": ");
            players[i] = new Player(scan.nextLine());
        }
        GuessNumber game = new GuessNumber(players);

        String yesNo = "да";
        while (!yesNo.equals("нет")) {
            if (yesNo.equals(("да"))) {
                game.play();
                System.out.println();
            }
            System.out.print("Новая игра [да/нет]? ");
            yesNo = scan.nextLine();
        }
    }
}