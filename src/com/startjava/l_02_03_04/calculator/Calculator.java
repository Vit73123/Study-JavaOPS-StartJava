package com.startjava.l_02_03_04.calculator;

public class Calculator {

    private static int num1;
    private static int num2;
    private static char sign;

    public static int calculate(String exp) throws WrongExpressionException {
        parseExpression(exp);

        return switch (sign) {
            case '+' -> Math.addExact(num1, num2);
            case '-' -> Math.subtractExact(num1, num2);
            case '*' -> Math.multiplyExact(num1, num2);
            case '/' -> Math.floorDiv(num1, num2);
            case '^' -> (int) Math.pow(num1, num2);
            case '%' -> Math.floorMod(num1, num2);
            default -> throw new WrongExpressionException();
        };
    }

    private static void parseExpression(String exp) throws WrongExpressionException {
        try {
            String[] tempExp = exp.split(" ");
            num1 = Integer.parseInt(tempExp[0]);
            num2 = Integer.parseInt(tempExp[2]);
            if (!(num1 > 0 && num2 > 0)) {
                throw new WrongExpressionException();
            }
            sign = tempExp[1].charAt(0);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new WrongExpressionException();
        }
    }

    public static class WrongExpressionException extends Exception {
    }
}