package com.startjava.l_02_03_04.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251"); // Консоль IntelliJ IDEA
        String yesNo = "да";

        while (yesNo.equals("да")) {
            System.out.print("Введите выражение: ");
            String exp = scan.nextLine();
            int result = 0;
            try {
                result = Calculator.calculate(exp);
                System.out.print("Результат: " + result + '\n');
            } catch (Calculator.WrongExpressionException e) {
                System.out.println("Ошибка в выражении");
            }
            do {
                System.out.print("Хотите продолжить вычисления? [да/нет]: ");
                yesNo = scan.nextLine();
            } while (!(yesNo.equals("да") || yesNo.equals("нет")));
        }
    }
}