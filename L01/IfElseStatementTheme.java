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
        char nameFirstLetter = name.charAt(0);
        System.out.println("Имя: " + name);
        if (nameFirstLetter == 'M') {
            System.out.println("Первая буква имени не \'М\'");
        } else if (nameFirstLetter == 'I') {
            System.out.println("Первая буква имени не \'I\'");
        } else {
            System.out.println("Подберите другое имя");
        }

        System.out.println("\n2. Поиск max и min числа\n" +
                "------------------------");
        double srcNumberDbl1 = 35.4;
        double srcNumberDbl2 = 45;
        System.out.println("Числа: " + srcNumberDbl1 + ", " + srcNumberDbl2);
        if (srcNumberDbl1 > srcNumberDbl2) {
            System.out.println("Max: " + srcNumberDbl1 + "; Min - " + srcNumberDbl2);
        } else if (srcNumberDbl1 < srcNumberDbl2) {
            System.out.println("Max - " + srcNumberDbl2 + "; Min - " + srcNumberDbl1);
        }

        System.out.println("\n3. Работа с числом\n" +
                "------------------");
        int srcNumberInt = -33;
        if (srcNumberInt == 0) {
            System.out.println("Число " + srcNumberInt + " - ноль");
        } else {
            if ((srcNumberInt % 2) == 0) {
                System.out.println("Число " + srcNumberInt + " - чётное");
            } else {
                System.out.println("Число " + srcNumberInt + " - нечётное");
            }
            if (srcNumberInt < 0) {
                System.out.println("            и отрицательное");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах\n" +
                "---------------------------------");
        int srcNumberInt1 = 324;
        int srcNumberInt2 = 427;
        int digit = 0;
        String msgNumbers = "";
        String msgDigits = "";
        String msgPosition = "";
        msgNumbers = String.valueOf(srcNumberInt1) + " и " + String.valueOf(srcNumberInt2);
        digit = srcNumberInt1 / 100;        
        if (digit == srcNumberInt2 / 100) {
            msgDigits = String.valueOf(digit);
            msgPosition = 2 + " ";
        }
        srcNumberInt1 %= 100;
        srcNumberInt2 %= 100;
        digit = srcNumberInt1 / 10;
        if (digit == srcNumberInt2 / 10) {
            msgDigits = String.valueOf(digit) + ", " + msgDigits;
            msgPosition = 1 + " " + msgPosition;
        }
        srcNumberInt1 %= 10;
        srcNumberInt2 %= 10;
        digit = srcNumberInt1;
        if (srcNumberInt1 == srcNumberInt2) {
            msgDigits = String.valueOf(srcNumberInt1) + " " + msgDigits;
            msgPosition = 0 + " " + msgPosition;
        }
        if (msgPosition == "") {
            msgDigits = " одинаковых цифр нет";
        } else {
            msgDigits = " одинаковая(ые) цифра(ы) " + msgDigits +
                "стоит(ят) в " + msgPosition +
                "разряде(ах)";
        }
        System.out.println("В числах " + msgNumbers + msgDigits);

        System.out.println("\n5. Определение буквы, числа или символа по их коду\n" +
                "--------------------------------------------------");
        char srcChar = '\u0057';
        String msgResult = "";
        if ((srcChar > '\u0040') && (srcChar < '\u005B')) {
            msgResult = "большая буква";
        } else if ((srcChar > '\u0060') && (srcChar < '\u007B')) {
            msgResult = "маленькая буква";
        } else if ((srcChar > '\u002F') && (srcChar < '\u003A')) {
            msgResult = "число";
        } else {
            msgResult = "не буква и не число";
        }
        System.out.println("Символ " + srcChar + " - " + msgResult);

        System.out.println("\n6. Определение суммы вклада и начисленных банком %\n" +
                "--------------------------------------------------");
        double srcDeposit = 300_000.0;
        msgResult = "Начисленный процент: ";
        if (srcDeposit < 100_000) {
            msgResult = msgResult + "5%\n" +
                  "Итоговая сумма: " + String.format("%.2f", srcDeposit * 1.05);
        } else if (srcDeposit <= 300_000) {
            msgResult = msgResult + "7%\n" +
                  "Итоговая сумма: " + String.format("%.2f", srcDeposit * 1.07);
        } else {
            msgResult = msgResult + "10%\n" +
                  "Итоговая сумма: " + String.format("%.2f", srcDeposit * 1.10);
        }
        System.out.println("Сумма вклада: " + String.format("%.2f", srcDeposit) + '\n' +
                msgResult);
    
        System.out.println("\n7. Определение оценки по предметам\n" +
                "----------------------------------");
        float pctHistory = 59;
        float pctProgramming = 91;
        byte markHistory = 0;
        byte markProgramming = 0;
        if (pctHistory > 91) {
            markHistory = 5;
        } else if (pctHistory > 73) {
            markHistory = 4;
        } else if (pctHistory > 60) {
            markHistory = 3;
        } else {
            markHistory = 2;
        }
        if (pctProgramming > 91) {
            markProgramming = 5;
        } else if (pctProgramming > 73) {
            markProgramming = 4;
        } else if (pctProgramming > 60) {
            markProgramming = 3;
        } else {
            markProgramming = 2;
        }
        System.out.println("История: " + markHistory + "\n" +
                "Математика: " + markProgramming + "\n" +
                "Средний бал: " +
                String.format("%.1f", ((float) (markHistory + markProgramming) / 2)) + "\n" +
                "Средний % по предметам: " +
                String.format("%.1f", ((pctHistory + pctProgramming) / 2)));
    
        System.out.println("\n8. Расчёт прибыли\n" +
                "-----------------");
        double monthRent = 5_000;
        double monthIncome = 15_000;
        double monthCost = 9_000;
        double yearProfit = (monthIncome - monthRent - monthCost) * 12;
        String yearProfitMsg;
        if ((yearProfit) < 0) {
            yearProfitMsg = String.format("%.2f", yearProfit);
        } else if ((yearProfit) > 0) {
            yearProfitMsg = String.format("+%.2f", yearProfit);
        } else {
            yearProfitMsg = "0.00";
        }
        System.out.println("Прибыль за год: " + yearProfitMsg);

        System.out.println("\n9. Определение существования треугольника\n" +
                "-----------------------------------------");
        double a = 3;
        double b = 4;
        double c = 5;
        if ((a >= c) || (b >= c)) {
            System.out.println("Неправильные данные. Сторона c не может быть меньше" +
                    "одной из других сторон\n");
        }
        if ((a * a) + (b * b) == (c * c)) {
            System.out.println("Гипотенуза (максимальное из чисел " +
                    a + ", "+ b + ", "+ c + "): " + c + "\n" +
                    "Катеты (остальные числа): " + a + ", " + b + "\n" +
                    "Площадь треугольника равна ((a * b) / 2): " +
                    String.format("%.1f", a * b / 2) + "\n");
            System.out.println("|\\" + "\n" +
                    "| \\" + "\n" +
                    "|  \\" + "\n" +
                    "|   \\" + "\n" +
                    " ___");
        } else {
            System.out.println("Треугольник с заданными длинами сторон не существует");
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