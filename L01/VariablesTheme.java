public class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Создание переменных и вывод их значений на консоль\n" +
                "-----------------------------------------------------");
        byte cpuCores = 12;
        System.out.println("CPU Количество ядер: " + cpuCores);
        float cpuFreq = 3.33F;
        System.out.println("CPU Частота: " + cpuFreq + " ГГц");
        short ram = 8_192;
        System.out.println("Оперативная память: " + ram + " МБ");
        int vram = 24_569;
        System.out.println("Видеопамять: " + vram + " МБ");
        double hddTotal = 11158.2D;
        System.out.println("Дисковое пространство: " + hddTotal + " ГБ");
        boolean hasSoundCard = true;
        System.out.println("Звуковая карта (есть / нет): " + hasSoundCard);
        System.out.println("\nДополнительная информация:");
        char grade = 'A';
        System.out.println("\nОценка производительности A-F: " + grade);
        long anyData = 0L;
        System.out.println("Дополнительные данные: " + anyData);
    
        System.out.println("\n2. Расчёт стоимости товара со скидкой\n" +
                "-------------------------------------");
        float priceX = 100;
        float priceY = 200;
        System.out.println("Сумма скидки : " + ((priceX + priceY) * 0.11F));
        System.out.println("Стоимость товаров со скидкой : " + 
                ((priceX + priceY) * (1 - 0.11F)));

        System.out.println("\n3. Вывод на консоль слова JAVA\n" +
                "------------------------------");
        System.out.println("   J    a  V     V  a" +
                "\n   J   a a  V   V  a a" +
                "\nJ  J  aaaaa  V V  aaaaa" +
                "\n JJ  a     a  V  a     a");

        System.out.println("\n4. Отображение min и max значений числовых типов данных\n" +
                "-------------------------------------------------------");
        byte varByte = Byte.MAX_VALUE;
        short varShort = Short.MAX_VALUE;
        int varInteger = Integer.MAX_VALUE;
        long varLong = Long.MAX_VALUE;
        System.out.println("Переменная типа byte: ");
        System.out.println("Первоначальное значение: " + varByte);
        System.out.println("Значение после инкремента: " + ++varByte);
        System.out.println("Значение после декремента результата: " + --varByte);
        System.out.println("\nПеременная типа short: ");
        System.out.println("Первоначальное значение: " + varShort);
        System.out.println("Значение после инкремента: " + ++varShort);
        System.out.println("Значение после декремента результата: " + --varShort);
        System.out.println("\nПеременная типа integer: ");
        System.out.println("Первоначальное значение: " + varInteger);
        System.out.println("Значение после инкремента: " + ++varInteger);
        System.out.println("Значение после декремента результата: " + --varInteger);
        System.out.println("\nПеременная типа long: ");
        System.out.println("Первоначальное значение: " + varLong);
        System.out.println("Значение после инкремента: " + ++varLong);
        System.out.println("Значение после декремента результата: " + --varLong);

        System.out.println("\n5. Перестановка значений переменных\n" +
                "-----------------------------------");
        float number1 = 1;
        float number2 = 2;
        float tmp = 0;
        System.out.println("Способ 1 - с помощью третьей переменной:\n" +
                "Исходные значения переменных:\n" +
                "number1: " + number1 + "\n" +
                "number2: " + number2);
        tmp = number1;
        number1 = number2;
        number2 = tmp;
        System.out.println("Новые значения переменных:\n" +
                "number1: " + number1 + "\n" +
                "number2: " + number2);
        number1 = 1;
        number2 = 2;
        System.out.println("\nСпособ 2 - с помощью арифметических операций:\n" +
                "Исходные значения переменных:\n" +
                "number1: " + number1 + "\n" +
                "number2: " + number2);
        number1 += number2;
        number2 = (float) (number1 - number2);
        number1 -= number2;
        System.out.println("Новые значения переменных:\n" +
                "number1: " + number1 + "\n" +
                "number2: " + number2);
        number1 = 1;
        number2 = 2;
        System.out.println("\nСпособ 3 - с помощью побитовой операции ^:\n" +
                "Исходные значения переменных:\n" +
                "number1: " + number1 + "\n" +
                "number2: " + number2);
        number1 = (float) ((int) number1 ^ (int) number2);
        number2 = (float) ((int) number1 ^ (int) number2);
        number1 = (float) ((int) number1 ^ (int) number2);
        System.out.println("Новые значения переменных:\n" +
                "number1: " + number1 + "\n" +
                "number2: " + number2);

        System.out.println("\n6. Вывод символов и их кодов\n" +
                "----------------------------");
        char charCode1 = 35;
        char charCode2 = 38;
        char charCode3 = 64;
        char charCode4 = 94;
        char charCode5 = 95;
        System.out.println("Код символа - Символ" + "\n" +
                (int) charCode1 + "   " + charCode1 + "\n" +
                (int) charCode2 + "   " + charCode2 + "\n" +
                (int) charCode3 + "   " + charCode3 + "\n" +
                (int) charCode4 + "   " + charCode4 + "\n" +
                (int) charCode5 + "   " + charCode5);

        System.out.println("\n7. Произведение и сумма цифр числа\n" +
                "----------------------------------");
        int srcNumber = 345;
        byte fig1;
        byte fig2;
        byte fig3;
        System.out.println("Число: " + srcNumber);
        fig1 = (byte) (srcNumber % 10);
        fig2 = (byte) ((srcNumber % 100) / 10);
        fig3 = (byte) (srcNumber / 100);
        System.out.println("Сумма цифр: " + (fig1 + fig2 + fig3));
        System.out.println("Произведение цифр: " + (fig1 * fig2 * fig3));

        System.out.println("\n8. Вывод на консоль ASCII-арт Дюка\n" +
                "----------------------------------");
        char space = ' ';
        char slash = '/';
        char backslash = '\\';
        char openParenthesis = '(';
        char closeParenthesis = ')';
        char underscore = '_';
        System.out.println("" + space + space + space + space + slash + backslash +
                space + space + space + space + '\n' +
                space + space + space + slash + space + space + backslash +
                space + space + space + '\n' +
                space + space + slash + underscore + openParenthesis + space +
                closeParenthesis + backslash + space + space + '\n' +
                space + slash + space + space + space + space + space + space +
                backslash + space + '\n' +
                slash + underscore + underscore + underscore + underscore + slash +
                backslash + underscore + underscore + backslash);

        System.out.println("\n9. Отображение количества сотен, десятков и единиц числа\n" +
               "--------------------------------------------------------");
        srcNumber = 123;
        System.out.println(srcNumber + " содержит: \n" +
                srcNumber / 100 + " сотен\n" +
                (srcNumber % 100) / 10 + " десятков\n" +
                srcNumber % 10 + " единиц\n");

        System.out.println("\n10. Преобразование секунд\n" +
                "--------------------------------------------------------");
        int totalSeconds = 86_399;
        System.out.println(totalSeconds + " секунд: " + (totalSeconds / 3600) + ':' +
                ((totalSeconds % 3600) / 60) + ':' + (totalSeconds % 60));
    }
}