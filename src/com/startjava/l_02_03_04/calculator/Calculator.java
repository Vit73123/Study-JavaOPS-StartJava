package com.startjava.l_02_03_04.calculator;

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

    public Integer calculate(String exp) {
        setExpressionParts(exp);
        switch (sign) {
            case '+':
                return Math.addExact(num1, num2);
            case '-':
                return Math.subtractExact(num1, num2);
            case '*':
                return Math.multiplyExact(num1, num2);
            case '/':
                return Math.floorDiv(num1, num2);
            case '^':
                return (int) Math.pow(num1, num2);
            case '%':
                return (int) Math.floorMod(num1, num2);
            default:
                System.out.println("Ошибка!");
                return null;
        }
    }

    private void setExpressionParts(String exp) {
        String[] expParts = exp.split(" ");
        num1 = Integer.parseInt(expParts[0]);
        num2 = Integer.parseInt(expParts[2]);
        sign = expParts[1].charAt(0);
    }
}