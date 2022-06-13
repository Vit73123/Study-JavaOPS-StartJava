public class Calculator {
    
    public static void main(String[] args) {
        int num1 = 8;
        int num2 = -5;
        int result = 0;
        char sign = '%';
        int error = 0;

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
                if (num2 == 0) {
                    error = 1;
                    break;
                }
                result = num1 / num2;
                break;
            case '^':
                result = pow(num1, num2);
                if (result == 0) {
                    error = 2;
                    break;
                }
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                error = 3;
        }
        if (error == 0) {
            System.out.println(num1 + " " + sign + " " + num2 + " = " + result);
        }
        switch (error) {
            case 1:
                System.out.println("Ошибка: Деление на ноль");
                break;
            case 2:
                System.out.println("Ошибка: Недопустимое значение степени: " + num2);
                break;
            case 3:
                System.out.println("Ошибка: Нет операции " + sign);
                break;
        }
    }

    private static int pow(int num, int numPow) {
        if (numPow < 0) {
            return 0;
        }
        int result = 1;
        for (int i = numPow; i > 0; i--) {
            result *= num;
        }
        return result;          
    }
}