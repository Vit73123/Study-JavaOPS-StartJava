package com.startjava.l_02_03.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "windows-1251");
        Calculator calc = new Calculator();
        String yesNo = "да";

        do {
            if (yesNo.equals("да")) {
                System.out.print("¬ведите первое число: ");
                calc.setNum1(scan.nextInt());
                System.out.print("¬ведите знак математической операции: ");
                calc.setSign(scan.next().charAt(0));
                System.out.print("¬ведите второе число: ");
                calc.setNum2(scan.nextInt());
                calc.calculate();
            }
            System.out.print("’отите продолжить вычислени€? [да/нет]: ");
            yesNo = scan.next();
            System.out.println("\'" + yesNo + "\'");
        } while (!yesNo.equals("нет"));
    }
}