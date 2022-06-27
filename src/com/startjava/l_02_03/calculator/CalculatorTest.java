package com.startjava.l_02_03.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "cp866");
        Calculator calc = new Calculator();
        String yesNo = "да";

        do {
            if (yesNo.equals("да")) {
                System.out.print("Введите первое число: ");
                calc.setNum1(scan.nextInt());
                System.out.print("Введите знак математической операции: ");
                calc.setSign(scan.next().charAt(0));
                System.out.print("Введите второе число: ");
                calc.setNum2(scan.nextInt());
                calc.calculate();
            }
            System.out.print("Хотите продолжить вычисления? [да/нет]: ");
            yesNo = scan.next();
            System.out.println("\'" + yesNo + "\'");
        } while (!yesNo.equals("нет"));
    }
}