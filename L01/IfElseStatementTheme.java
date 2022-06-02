public class IfElseStatementTheme {
    
    public static void main(String[] args) {
        System.out.println("\n1. Перевод псевдокода на язык Java\n" +
                "----------------------------------");
        int age = 30;
        System.out.println("Возраст: " + age);
        if (age > 20) {
            System.out.println("Возраст больше 20 лет");
        } else {
            System.out.println("Возраст до 20 лет\n");
        }
        char gender = 'M';
        System.out.println("Пол: " + gender);
        if (gender != 'M') {
            System.out.println("Пол должен быть мужской\n");
        }
        float height = 1.58F;
        System.out.println("Рост: " + height);
        if (height < 1.8F) {
            System.out.println("Рост меньше 1,8 м\n");
        } else {
            System.out.println("Рост не менее 1,8 м\n");
        }
        String name = "Anyname";
        char firstLetterName = name.charAt(0);
        System.out.println("Имя: " + name);
        if (firstLetterName == 'M') {
            System.out.println("Первая буква имени не \'М\'");
        } else if (firstLetterName == 'I') {
            System.out.println("Первая буква имени не \'I\'");
        } else {
            System.out.println("Подберите другое имя");
        }

        System.out.println("\n2. Поиск max и min числа\n" +
                "------------------------");
        double number1 = 35.4;
        double number2 = 45;
        System.out.println("Числа: " + number1 + ", " + number2);
        if (number1 > number2) {
            System.out.println("Max: " + number1 + "; Min - " + number2);
        } else if (number1 < number2) {
            System.out.println("Max - " + number2 + "; Min - " + number1);
        }

        System.out.println("\n3. Работа с числом\n" +
                "------------------");
        int number = -33;
        if (number == 0) {
            System.out.println("Число " + number + " - ноль");
        } else {
            if ((number % 2) == 0) {
                System.out.println("Число " + number + " - чётное");
            } else {
                System.out.println("Число " + number + " - нечётное");
            }
            if (number < 0) {
                System.out.println("            и отрицательное");
            } else {
                System.out.println("            и положительное");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах\n" +
                "---------------------------------");
        int srcNumber1 = 324;
        int srcNumber2 = 427;
        int digit = -1;
        System.out.println("В числах " + srcNumber1 + " и " + srcNumber2);
        digit = srcNumber1 / 100;
        if (digit == srcNumber2 / 100) {
            System.out.println("одинаковая цифра "+ digit + " стоит в разряде 3");
        }
        digit = (srcNumber1 %= 100) / 10;
        if (digit == (srcNumber2 %= 100) / 10) {
            System.out.println("одинаковая цифра "+ digit + " стоит в разряде 2");
        }
        digit = srcNumber1 % 10;
        if (digit == (srcNumber2 % 10)) {
            System.out.println("одинаковая цифра "+ digit + " стоит в разряде 1");
        }
        if (digit == -1) {
            System.out.println("одинаковых цифр нет");
        }

        System.out.println("\n5. Определение буквы, числа или символа по их коду\n" +
                "--------------------------------------------------");
        char srcChar = '\u0057';
        System.out.println("Символ " + srcChar + " - ");
        if ((srcChar >= 'A') && (srcChar <= 'Z')) {
            System.out.println("большая буква");
        } else if ((srcChar >= 'a') && (srcChar <= 'z')) {
            System.out.println("маленькая буква");
        } else if ((srcChar >= '0') && (srcChar <= '9')) {
            System.out.println("число");
        } else {
            System.out.println("не буква и не число");
        }

        System.out.println("\n6. Определение суммы вклада и начисленных банком %\n" +
                "--------------------------------------------------");
        double deposit = 300_000.0;
        double percent;
        if (deposit < 100_000) {
            percent = 1.05;
        } else if (deposit <= 300_000) {
            percent = 1.07;
        } else {
            percent = 1.1;
        }
        System.out.println("Начисленный процент: " + String.format("%.2f", percent));
        System.out.println("Итоговая сумма: " + String.format("%,.2f", deposit * percent));
    
        System.out.println("\n7. Определение оценки по предметам\n" +
                "----------------------------------");
        float gradeHistory = 59;
        float gradeProgramming = 91;
        byte markHistory = 0;
        byte markProgramming = 0;
        if (gradeHistory > 91) {
            markHistory = 5;
        } else if (gradeHistory > 73) {
            markHistory = 4;
        } else if (gradeHistory > 60) {
            markHistory = 3;
        } else {
            markHistory = 2;
        }
        if (gradeProgramming > 91) {
            markProgramming = 5;
        } else if (gradeProgramming > 73) {
            markProgramming = 4;
        } else if (gradeProgramming > 60) {
            markProgramming = 3;
        } else {
            markProgramming = 2;
        }
        System.out.println("История: " + markHistory + "\n" +
                "Математика: " + markProgramming + "\n" +
                "Средний бал: " +
                String.format("%.1f", ((float) (markHistory + markProgramming) / 2)) + "\n" +
                "Средний % по предметам: " +
                String.format("%.1f", ((gradeHistory + gradeProgramming) / 2)));
    
        System.out.println("\n8. Расчёт прибыли\n" +
                "-----------------");
        double monthRent = 5_000;
        double monthIncome = 15_000;
        double monthCost = 9_000;
        double yearProfit = (monthIncome - monthRent - monthCost) * 12;
        String yearProfitMsg;
        if (yearProfit < 0) {
            yearProfitMsg = String.format("%.2f", yearProfit);
        } else if (yearProfit > 0) {
            yearProfitMsg = String.format("+%.2f", yearProfit);
        } else {
            yearProfitMsg = "0.00";
        }
        System.out.println("Прибыль за год: " + yearProfitMsg);

        System.out.println("\n9. Определение существования треугольника\n" +
                "-----------------------------------------");
        double catet1 = 3;
        double catet2 = 4;
        double hypotenuse = 5;
        double temp;
        if (hypotenuse < catet1) {
            temp = hypotenuse;
            hypotenuse = catet1;
            catet1 = temp;
        } else if (hypotenuse < catet2) {
            temp = hypotenuse;
            hypotenuse = catet1;
            catet1 = temp;
        }
        if ((catet1 + catet2) <= hypotenuse) {
            System.out.println("Треугольник с заданными длинами сторон не существует");
        } else  if ((catet1 * catet1) + (catet2 * catet2) == (hypotenuse * hypotenuse)) {
            System.out.println("Площадь треугольника равна ((a * b) / 2): " +
                    String.format("%.1f", catet1 * catet2 / 2) + "\n");
            System.out.println("|\\" + "\n" +
                    "| \\" + "\n" +
                    "|  \\" + "\n" +
                    "|___\\");
        }

        System.out.println("\n10. Подсчёт количества банкнот\n" +
                "------------------------------");
        double srcSum = 567;
        double chkSum;
        int bnk100;
        int bnk10;
        int bnk1;
        bnk100 = (int) (srcSum / 100);
        bnk10 = ((int) srcSum % 100) / 10;
        if (bnk10 > 5) {
            bnk10 = 5;
        }
        bnk1 = (int) (srcSum - bnk100 * 100 - bnk10 * 10);
        chkSum = bnk100 * 100 + bnk10 * 10 + bnk1;
        if (chkSum != srcSum) {
            System.out.println("Ошибка!");
        } else {
            System.out.println("Количество банкнот по номиналу:\n" +
                    "100: " + bnk100 + "\n" +
                    "10: " + bnk10 + "\n" +
                    "1: " + bnk1 + "\n" +
                    "Исходная сумма: " + chkSum);
        }
    }
}