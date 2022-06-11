public class Calculator {
    
    static int pow(int num, int numPow) {
        int i;
        int tempResult = num;
        if (numPow > 0) {
            for (i = numPow - 1; i > 0; i--) {
                tempResult *= num;
                System.out.println(tempResult);
            }
            System.out.println(tempResult);
            return tempResult;          
        } else if (numPow == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int num1 = 8;
        int num2 = -5;
        int tempResult;
        char sign = '%';

        switch (sign) {
            case '+':
                System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Ошибка: Деление на ноль");
                    break;
                }
                System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1 / num2));
                break;
            case '^':
                tempResult = pow(num1, num2);
                if (tempResult == 0) {
                    System.out.println("Ошибка: Недопустимое значение степени: " + num2);
                    break;
                }
                System.out.println(num1 + " " + sign + " " + num2 + " = " + tempResult);
                break;
            case '%':
                System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1 % num2));
                break;
            default:
                System.out.println("Ошибка: Нет операции " + sign);
        }
    }
}