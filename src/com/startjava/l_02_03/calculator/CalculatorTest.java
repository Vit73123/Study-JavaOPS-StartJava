package com.startjava.l_02_03.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calc = new Calculator();
        String yesNo = "yes";

        do {
            if (yesNo.equals("yes")) {
                System.out.print("Введите первое число: ");
                calc.setNum1(scan.nextInt());
                System.out.print("Введите знак математической операции: ");
                calc.setSign(scan.next().charAt(0));
                System.out.print("Введите второе число: ");
                calc.setNum2(scan.nextInt());
                calc.calculate();
            }
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            yesNo = scan.next();            
        } while (!yesNo.equals("no"));
    }
}