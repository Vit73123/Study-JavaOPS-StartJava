package com.startjava.l_02_03_04.calculator;

public class Calculator {

    private static int num1;
    private static int num2;
    private static char sign;
    private static boolean hasError;

    public static boolean hasError() {
        return hasError;
    }

    public static int calculate(String exp) {
        hasError = false;
        setExpression(exp);
        int result = switch (sign) {
            case '+' -> Math.addExact(num1, num2);
            case '-' -> Math.subtractExact(num1, num2);
            case '*' -> Math.multiplyExact(num1, num2);
            case '/' -> Math.floorDiv(num1, num2);
            case '^' -> (int) Math.pow(num1, num2);
            case '%' -> Math.floorMod(num1, num2);
            default -> {
                hasError = true;
                yield 0;
            }
        };
        if (hasError) {
            System.out.println("Ошибка в выражении!");
        }
        return result;
    }

    private static void setExpression(String exp) {
        String[] tempExp = exp.split(" ");
        try {
            num1 = Integer.parseInt(tempExp[0]);
            num2 = Integer.parseInt(tempExp[2]);
            if (!(num1 > 0 && num2 > 0)) hasError = true;
        } catch (NumberFormatException e) {
            hasError = true;
        }
        if (!hasError) sign = tempExp[1].charAt(0);
    }
}