public class VariablesTheme {

    public static void main(String[] args) {
        
        {
        System.out.println("\n1. Создание переменных и вывод их значений на консоль" +
                           "\n-----------------------------------------------------");
        byte cpuCores = 12;
        System.out.println("\nCPU Количество ядер: " + cpuCores);
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
        }

        {
        System.out.println("\n3. Вывод на консоль слова JAVA" +
                           "\n------------------------------");
        float priceX = 100F;
        float priceY = 200F;
        System.out.println("\nСумма скидки : " + ((priceX + priceY) * 0.11F));
        System.out.println("Стоимость товаров со скидкой : " + ((priceX + priceY) * (1 - 0.11F)));

        System.out.println("\n3. Вывод на консоль слова JAVA" +
                           "\n------------------------------");
        System.out.println("\n   J    a  V     V  a" +
                           "\n   J   a a  V   V  a a" +
                           "\nJ  J  aaaaa  V V  aaaaa" +
                           "\n JJ  a     a  V  a     a");
        }

        {
        System.out.println("\n4. Отображение min и max значений числовых типов данных" +
                           "\n-------------------------------------------------------");
        byte varByte = Byte.MAX_VALUE;
        short varShort = Short.MAX_VALUE;
        int varInteger = Integer.MAX_VALUE;
        long varLong = Long.MAX_VALUE;
        System.out.println("\nПеременная типа byte: ");
        System.out.println("Первоначальное значение: " + varByte);
        varByte++;
        System.out.println("Значение после инкремента: " + varByte);
        varByte--;
        System.out.println("Значение после декремента результата: " + varByte);
        System.out.println("\nПеременная типа short: ");
        System.out.println("Первоначальное значение: " + varShort);
        varShort++;
        System.out.println("Значение после инкремента: " + varShort);
        varShort--;
        System.out.println("Значение после декремента результата: " + varShort);
        System.out.println("\nПеременная типа integer: ");
        System.out.println("Первоначальное значение: " + varInteger);
        varInteger++;
        System.out.println("Значение после инкремента: " + varInteger);
        varInteger--;
        System.out.println("Значение после декремента результата: " + varInteger);
        System.out.println("\nПеременная типа long: ");
        System.out.println("Первоначальное значение: " + varLong);
        varLong++;
        System.out.println("Значение после инкремента: " + varLong);
        varLong--;
        System.out.println("Значение после декремента результата: " + varLong);
        }

        {
        System.out.println("\n5. Перестановка значений переменных" +
                           "\n-----------------------------------");
        float var1 = 1F;
        float var2 = 2F;
        float varTemp = 0;
        System.out.println("\nСпособ 1 - с помощью третьей переменной:" +
                           "\nИсходные значения переменных:" +
                           "\nvar1: " + var1 +
                           "\nvar2: " + var2);
        varTemp = var1;
        var1 = var2;
        var2 = varTemp;
        System.out.println("\nНовые значения переменных:" +
                           "\nvar1: " + var1 +
                           "\nvar2: " + var2);
        var1 = 1F;
        var2 = 2F;
        System.out.println("\nСпособ 2 - с помощью арифметических операций:" +
                           "\nИсходные значения переменных:" +
                           "\nvar1: " + var1 +
                           "\nvar2: " + var2);
        var1 += var2;
        var2 = (float) (var1 - var2);
        var1 -= var2;
        System.out.println("\nНовые значения переменных:" +
                           "\nvar1: " + var1 +
                           "\nvar2: " + var2);
        var1 = 1F;
        var2 = 2F;
        System.out.println("\nСпособ 3 - с помощью побитовой операции ^:" +
                           "\nИсходные значения переменных:" +
                           "\nvar1: " + var1 +
                           "\nvar2: " + var2);
        var1 = (float) ((int) var1 ^ (int) var2);
        var2 = (float) ((int) var1 ^ (int) var2);
        var1 = (float) ((int) var1 ^ (int) var2);
        System.out.println("\nНовые значения переменных:" +
                           "\nvar1: " + var1 +
                           "\nvar2: " + var2);
        }

        {
        System.out.println("\n6. Вывод символов и их кодов" +
                           "\n----------------------------");

        char var1 = 35;
        char var2 = 38;
        char var3 = 64;
        char var4 = 94;
        char var5 = 95;
        System.out.println("\nКод символа - Сивол" + 
                           "\n" + (int) var1 + "   " + var1 +
                           "\n" + (int) var2 + "   " + var2 +
                           "\n" + (int) var3 + "   " + var3 +
                           "\n" + (int) var4 + "   " + var4 +
                           "\n" + (int) var5 + "   " + var5);
        }

        {
        System.out.println("\n7. Произведение и сумма цифр числа" +
                           "\n----------------------------------");
        int var = 345;
        System.out.println("\nЧисло: " + var);
        var = (var / 100) + ((var %= 100) / 10) + (var %= 10);
        System.out.println("Сумма цифр: " + var);
        var = 345;
        var = (var / 100) * ((var %= 100) / 10) * (var %= 10);
        System.out.println("Произведение цифр: " + var);
        }

        {
        System.out.println("\n8. Вывод на консоль ASCII-арт Дюка" +
                           "\n----------------------------------");
        char spc = ' ';
        char slf = '/';
        char slb = '\\';
        char sco = '(';
        char scc = ')';
        char com = '.';
        char und = '_';
        System.out.println("\n" + spc + spc + spc + spc + slf + slb + spc + spc + spc + spc +
                           '\n' + spc + spc + spc + slf + spc + spc + slb + spc + spc + spc +
                           '\n' + spc + spc + slf + und + sco + spc + scc + slb + spc + spc +
                           '\n' + spc + slf + spc + spc + spc + spc + scc + spc + slf + spc +
                           '\n' + slf + und + und + und + und + slf + slb + und + und + slf);
        }

        {
        System.out.println("\n9. Отображение количества сотен, десятков и единиц числа" +
                           "\n--------------------------------------------------------");
        int var = 123;
        System.out.println('\n' + var + " содержит: " +
                           '\n' + var / 100 + " сотен" +
                           '\n' + var / 10 + " десятков" +
                           '\n' + var % 10 + " единиц");
        }

        {
        System.out.println("\n10. Преобразование секунд" +
                           "\n--------------------------------------------------------");
        int var = 86_399;
        System.out.println('\n' + var + " секунд: " +
                           (var / 3600) + ':' +
                           ((var % 3600) / 60) + ':' +
                           (var % 60));
        }
    }
}