package com.startjava.l_02_03_04.array;

import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Реверс значений массива\n--------------------------");
        int[] intArr = {1, 2, 3, 4, 5, 6, 7};
        int len = intArr.length;
        printArrayInt(intArr);

        for (int i = 0; i < len / 2; i++) {
            int index = len - i - 1;
            int tmpNum = intArr[i];
            intArr[i] = intArr[index];
            intArr[index] = tmpNum;
        }
        printArrayInt(intArr);

        System.out.println("\n2. Вывод произведения элементов массива\n---------------------------------------");
        intArr = new int[10];
        len = intArr.length;
        for (int i = 0; i < len; i++) intArr[i] = i;
        int result = 1;
        for (int i = 2; i < len - 1; i++) result *= intArr[i];
        for (int i = 1; i < len - 1; i++) {
            System.out.print(intArr[i] + (i < len - 2 ? " * " : (" = " + result) + '\n'));
        }
        System.out.println("Число "+ intArr[0] + " находится под индексом " + 0);
        System.out.println("Число "+ intArr[9] + " находится под индексом " + 9);

        System.out.println("\n3. Удаление элементов массива\n-----------------------------\n");
        double[] doubleArr = new double[15];
        len = doubleArr.length;
        for (int i = 0; i < len; i++) {
            doubleArr[i] = Math.random();
        }
        printArrayDouble(doubleArr, "%8.5f", 8);

        double middleNum = doubleArr[len / 2];
        int countZeros = 0;
        for (int i = 0; i < len; i++) {
            if (doubleArr[i] > middleNum) {
                doubleArr[i] = 0;
                countZeros++;
            }
        }
        printArrayDouble(doubleArr, "%8.5f", 8);
        System.out.println("Количество обнулённых ячеек " + countZeros);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке\n------------------------------------------------------");
        char[] chars = new char[(int) ('Z' - 'A' + 1)];
        len = chars.length;
        for (int i = 0; i < len; i++) chars[i] = (char) ('A' + i);
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > len - 2 - i; j--) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел\n-----------------------------");
        intArr = new int[30];
        len = intArr.length;
        for (int i = 0; i < len; i++) {
            int tmpNum;
            boolean isExist;
            do {
                tmpNum = (int) (60 + 41 * Math.random());
                isExist = false;
                for (int j = 0; j < i; j++) {
                    if (intArr[j] == tmpNum) {
                        isExist = true;
                        break;
                    }
                }
            } while (isExist);
            intArr[i] = tmpNum;
        }
        Arrays.sort(intArr);
        int cols = 1;
        for (int num : intArr) {
            System.out.printf("%4d", num);
            if (cols++ % 10 == 0) System.out.println();
        }

        System.out.println("\n6. Сдвиг элементов массива\n-----------------------------");
        String[] srcArr = {"", "AA", "", "", "BBB", "C", "", "DDDD"};
        len = 0;
        for (String s : srcArr) {
            if (!s.isBlank()) len++;
        }
        String[] destArr = new String[len];
        len = srcArr.length;
        int destPos = 0;
        for (int i = 0; i < len; i++) {
            int srcPos = i;
            while (!srcArr[i].isBlank()) {
                if (++i == len) break;
            }
            if (i > srcPos) {
                int numStrings = i - srcPos;
                System.arraycopy(srcArr, srcPos, destArr, destPos, numStrings);
                if (i < len) destPos += numStrings;
            }
        }
        System.out.println(Arrays.toString(srcArr));
        System.out.println(Arrays.toString(destArr));
    }

    private static void printArrayInt(int[] ints) {
        for (int num : ints) System.out.printf("%4d", num);
        System.out.println();
    }

    private static void printArrayDouble(double[] doubles, String fString, int fCols) {
        fCols = fCols > 0 ? fCols : doubles.length;
        int i = 0;
        for (double num : doubles) {
            System.out.printf(fString, num);
            i++;
            if (i == fCols) {
                i = 0;
                System.out.println();
            }
        }
        System.out.println('\n');
    }
}