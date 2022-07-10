package com.startjava.l_02_03.calculator;

public class Calculator {
    private int num1;
    private int num2;
    private char sign;
 
    public void setNum1(int num) {
        num1 = num;
    }

    public void setNum2(int num) {
        num2 = num;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void calculate() {
        switch (sign) {
            case '+':
                System.out.println(num1 + num2);
                break;
            case '-':
                System.out.println(num1 - num2);
                break;
            case '*':
                System.out.println(num1 * num2);
                break;
            case '/':
                System.out.println(num1 / num2);
                break;
            case '^':
                System.out.println(pow());
                break;
            case '%':
                System.out.println(num1 % num2);
                break;
            default:
                System.out.println("Îøèáêà!");
        }
    }

    private int pow() {
        int result = 1;
        for (int i = num2; i > 0; i--) {
            result *= num1;
        }
        return result;          
    }
}