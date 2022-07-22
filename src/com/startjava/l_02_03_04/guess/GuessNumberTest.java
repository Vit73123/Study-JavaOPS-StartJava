package com.startjava.l_02_03_04.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251");

        System.out.print("\nВведите имя игрока 1: ");
        Player player1 = new Player(scan.nextLine());
        System.out.print("Введите имя игрока 2: ");
        Player player2 = new Player(scan.nextLine());
        GuessNumber guessNumber = new GuessNumber(player1, player2);
        System.out.println("У каждого игрока по " + guessNumber.getCountAttempts() + " попыток");

        String yesNo = "да";
        while (yesNo.equals("да")) {
            guessNumber.play();
            do {
                System.out.print("\nНовая игра [да/нет]? ");
                yesNo = scan.nextLine();
                System.out.println();
            } while (!(yesNo.equals("да") || yesNo.equals("нет")));
        }
    }
}