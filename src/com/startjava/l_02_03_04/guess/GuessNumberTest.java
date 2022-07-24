package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251");  // Консоль в IntelliJ IDE

        System.out.print("\nВведите имя игрока 1: ");
        Player player1 = new Player(scan.nextLine());
        System.out.print("Введите имя игрока 2: ");
        Player player2 = new Player(scan.nextLine());
        GuessNumber game = new GuessNumber(player1, player2);

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