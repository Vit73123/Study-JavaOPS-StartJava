package com.startjava.l_02_03_04.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251");
        String yesNo = "да";

        while (!yesNo.equals("нет")) {
            if (!yesNo.equals("да")) continue;

            System.out.print("Введите выражение: ");
            String exp = scan.nextLine();
            int result = Calculator.calculate(exp);
            if (Calculator.hasError()) continue;

            System.out.print("Результат: " + result + '\n');
            System.out.print("Хотите продолжить вычисления? [да/нет]: ");
            yesNo = scan.nextLine();
        }
    }
}