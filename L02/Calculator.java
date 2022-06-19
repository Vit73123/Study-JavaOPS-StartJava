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
        if (! isError()) {
            int result = 0;
            switch (sign) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '^':
                    result = pow(num1, num2);
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            System.out.println(num1 + " " + sign + " " + num2 + " = " + result);
        }
    }

    private static int pow(int num, int numPow) {
        int result = 1;
        for (int i = numPow; i > 0; i--) {
            result *= num;
        }
        return result;          
    }

    private boolean isError() {
        boolean check = false;
        switch (sign) {
            case '+': break;
            case '-': break;
            case '*': break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Ошибка: Деление на ноль");
                    check = true;
                }
                break;
            case '^':
                if (num2 < 0) {
                    System.out.println("Ошибка: Недопустимое значение степени: " + num2);
                    check = true;
                }
                break;
            case '%': break;
            default:
                System.out.println("Ошибка: Нет операции " + sign);
                check = true;
        }
        return check;
    }
}