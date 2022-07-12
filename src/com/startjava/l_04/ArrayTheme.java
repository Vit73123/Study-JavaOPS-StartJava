package com.startjava.l_04;

import java.util.Arrays;
import java.util.Random;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Реверс значений массива\n--------------------------");
        int[] intArr = {1, 2, 3, 4, 5, 6, 7};
        printArrayInt(intArr);
        System.out.println();
        for (int i = 0; i < intArr.length / 2; i++) {
            int reverseNumberIndex = intArr.length - i - 1;
            int numTemp = intArr[i];
            intArr[i] = intArr[reverseNumberIndex];
            intArr[reverseNumberIndex] = numTemp;
        }
        printArrayInt(intArr);

        System.out.println("\n\n2. Вывод произведения элементов массива\n---------------------------------------");
        intArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = 1;
        for (int i = 1; i < 9; i++) {
            result *= intArr[i];
            System.out.print(intArr[i] + (i < 8 ? " * " : " = "));
        }
        System.out.print(result);
        System.out.println("\nЧисла " + intArr[0] + " и " + intArr[9] + " исключаются");

        System.out.println("\n3. Удаление элементов массива\n-----------------------------\n");
        int len = 15;
        double[] doubleArr = new double[len];
        for (int i = 0; i < len; i++) {
            doubleArr[i] = (float) Math.random();
        }
        printArrayDouble(doubleArr, "%8.5f", 8);
        double middleNumber = doubleArr[len / 2];
        int zeroNumbersCount = 0;
        for (int i = 0; i < len; i++) {
            if (doubleArr[i] > middleNumber) {
                doubleArr[i] = 0;
                zeroNumbersCount++;
            }
        }
        printArrayDouble(doubleArr, "%8.5f", 8);
        System.out.println("Количество обнулённых яеек " + zeroNumbersCount);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке\n------------------------------------------------------");
        int charsCount = 'Z' - 'A' + 1;
        char[] chars = new char[charsCount];
        for (int i = 0; i < charsCount; i++) chars[i] = (char) ('A' + i);
        int rowNumber = 0;
        int charNumber = 0;
        for (int i = 0; i < charsCount; i++) {
            System.out.print(chars[i]);
            if (charNumber == rowNumber) {
                rowNumber++;
                charNumber = 0;
                System.out.println();
            }
            charNumber++;
        }

        System.out.println("\n\n5. Генерация уникальных чисел\n-----------------------------");
        Random random = new Random();
        len = 30;
        intArr = new int[len];
        for (int i = 0; i < len; i++) {
            intArr[i] = 60 + random.nextInt(41);
            for (int j = 0; j < i; j++) {
                if (intArr[j] == intArr[i]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(intArr);
        printArrayInt(intArr, "%4d", 10);

        System.out.println("\n6. Сдвиг элементов массива\n-----------------------------");
        String[] srcArr = {"", "AA", "", "", "BBB", "C", "", "DDDD"};
        len = srcArr.length;
        int dstCount = len;
        for (int i = 0; i < len; i++) { if (srcArr[i].isBlank()) { dstCount--; } }
        String[] dstArr = new String[dstCount];
        int dstPos = 0;
        int numStrings = 0;
        for (int i = 0; i < len; i++) {
            boolean isEmpty = srcArr[i].isBlank();
            boolean isEnd = i == (len - 1);
            if (!isEmpty) { numStrings++; }
            if ((isEmpty || isEnd) && numStrings > 0) {
                int srcPos = i - numStrings + (isEnd ? 1 : 0);
                System.arraycopy(srcArr, srcPos, dstArr, dstPos, numStrings);
                if (!isEnd) {
                    dstPos += numStrings;
                    numStrings = 0;
                }
            }
        }
        System.out.println(Arrays.toString(srcArr));
        System.out.println(Arrays.toString(dstArr));
    }

    private static void printArrayInt(int[] ints) {
        for (int num : ints) System.out.print(num + " ");
    }

    private static void printArrayInt(int[] ints, String fString, int fCols) {
        fCols = fCols > 0 ? fCols : ints.length;
        int i = 0;
        for (int num : ints) {
            System.out.printf(fString, num);
            i++;
            if (i == fCols) {
                i = 0;
                System.out.println();
            }
        }
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
