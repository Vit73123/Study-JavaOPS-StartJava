public class CyclesTheme {
    
    public static void main(String[] args) {
        System.out.println("\n1. Подсчёт суммы чётных и нечётных чисел\n" +
                "----------------------------------------");            
        int numEven = 0;
        int numOdd = 0;
        int i = -10;
        do {
            if ((i % 2) == 0) {
                numEven++;
            } else {
                numOdd++;
            }
            i++;
        } while (i <= 21);
        System.out.println("В промежутке [-10, 21] сумма чётных чисел = " + numEven +
                ", а нечётных = " + numOdd);

        System.out.println("\n2. Вывод чисел в интервале между (max и min)\n" +
                "--------------------------------------------");            
        int min = 10;
        int max = -1;
        if (min > max) {
            max += min;
            min = max - min;
            max -= min;
        }
        if (max < 5) {
            max = 5;
        } else if (min > 5) {
            min = 5;
        }
        for (i = max - 1; i > min; i--) {
            System.out.println(i);
        }

        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр\n" +
                "--------------------------------------------");            
        int srcNumber = 1234;
        int reverseNumber = 0;
        int pos = 1000;
        int sum = 0;
        while (srcNumber > 0) {
            reverseNumber += (srcNumber % 10) * pos;
            sum += srcNumber % 10;
            srcNumber /= 10;
            pos /= 10;
        }
        System.out.println("Исходное число в обратном порядке: " + reverseNumber + "\n" +
                "Сумма цифра: " + sum);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк\n" +
                "-------------------------------------------");
        for (i = 1; i < 24; i+=2) {
            if (((i - 1) % (5 * 2)) == 0) {
                System.out.print('\n');
            }
            System.out.printf("%3d", i);
        }
        while (((i - 1) % (5 * 2)) != 0 ) {
            System.out.printf("%3d", 0);
            i += 2;
        }

        System.out.println("\n\n5. Проверка количества единиц на чётность\n" +
                "-----------------------------------------");
        srcNumber = 3_141_591;
        int temp = srcNumber;
        int numOnes = 0;
        String msgOnesParity = " (чётное) ";
        while (temp > 0) {
            if ((temp % 10) == 1) {
                numOnes++;
            }
            temp /= 10;
        }
        if ((numOnes % 2) != 0) {
            msgOnesParity = "(нечётное)";
        }
        System.out.printf("Число %,d содержит %d %s количество единиц%n",
                srcNumber, numOnes, msgOnesParity);

        System.out.println("\n6. Отображение фигур в консоли\n" +
                "------------------------------");
        System.out.println();
        for (i = 5; i > 0; i--) {
            System.out.println ("*".repeat(5));
        }
        System.out.println(); 
        i = 5;
        while (i > 0) {
            System.out.println ("#".repeat(i--));
        }
        System.out.println(); 
        i = 5;
        int j = 1;
        do {
            System.out.println("$".repeat(j));
            if (i > 3) {
                j++;
            } else {
                j--;
            }
            i--;
        } while (i > 0);

        System.out.println("\n7. Отображение ASCII-символов\n" +
                "-----------------------------");
        System.out.printf("%5s%5s\n", "Dec", "Char");
        char c;
        for (c = 0; c < '0'; c++) {
            if ((c % 2) != 0) {
                System.out.printf("%5d%5c\n", (int) c, c);
            }
        }
        System.out.println();
        for (c = 'a'; c <= 'z'; c++) {
            if ((c % 2) == 0) {
                System.out.printf("%5d%5c\n", (int) c, c);
            }
        }

        System.out.println("\n8. Проверка, является ли число полиндромом\n" +
                "------------------------------------------");
        srcNumber = 1234321;
        String srcNumberString = String.valueOf(srcNumber);
        int checkWidth = srcNumberString.length();
        char digit1;
        char digit2;
        i = 0;
        j = checkWidth - 1;
        checkWidth /= 2;
        do {
            digit1 = srcNumberString.charAt(i++);
            digit2 = srcNumberString.charAt(j--);
        } while ((digit1 == digit2) && (i < checkWidth));
        System.out.print("Число " + srcNumberString);
        if (i < checkWidth) {
            System.out.println(" не является полиндромом");
        } else {
            System.out.println(" является полиндромом");
        }

        System.out.println("\n9. Определение, является ли число счастливым\n" +
                "--------------------------------------------");
        srcNumber = 123321;
        srcNumberString = String.valueOf(srcNumber);
        checkWidth = srcNumberString.length();
        int digitSum1 = 0;
        int digitSum2 = 0;
        i = 0;
        j = checkWidth - 1;
        checkWidth /= 2;
        do {
            digitSum1 += Character.getNumericValue(srcNumberString.charAt(i++));
            digitSum2 += Character.getNumericValue(srcNumberString.charAt(j--));
        } while (i < checkWidth);
        System.out.println("Сумма цифр " +
                srcNumberString.substring(0, checkWidth) + ": " + digitSum1);
        System.out.println("Сумма цифр " +
                srcNumberString.substring(checkWidth) + ": " + digitSum2);
        if (digitSum1 == digitSum2) {
            System.out.println("Число " + srcNumber + " счастливое");
        } else {
            System.out.println(srcNumber + " - обычное число");
        }

        System.out.println("\n10. Вывод таблицы Пифагора\n" +
                "--------------------------");
        String strVert = "\u2502";
        String strHor = "\u2500";
        String strCross = "\u253C";
        System.out.print("   ТАБЛИЦА ПИФАГОРА\n" +
                "  " + strVert);
        for (i = 2; i < 10; i++) {
            System.out.printf("%3d", i);
        }
        System.out.print("\n" + strHor.repeat(2) + strCross + strHor.repeat((9 - 1) * 3));
        j = 1;
        for (i = 0; i < (9 - 2 + 1) * 10; i++) {
            if (i % 10 == 0) {
                i += 2;
                j++;
                System.out.print("\n" + j + " " + strVert);
            }
            System.out.printf("%3d", i % 10 * j);
        }
   }
}