package com.startjava.l_02_03_04.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251"); // Консоль IntelliJ IDEA
        Calculator calc = new Calculator();
        String yesNo = "да";

        do {
            if (yesNo.equals("да")) {
                System.out.print("Введите выражение: ");
                String exp = scan.nextLine();
                System.out.print("Результат: " + calc.calculate(exp) + '\n');
            }
            System.out.print("Хотите продолжить вычисления? [да/нет]: ");
            yesNo = scan.nextLine();
            System.out.println("\'" + yesNo + "\'");
        } while (!yesNo.equals("нет"));
    }
}