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
            int iReverse = intArr.length - i - 1;
            int numTemp = intArr[i];
            intArr[i] = intArr[iReverse];
            intArr[iReverse] = numTemp;
        }
        printArrayInt(intArr);

        System.out.println("\n\n2. Вывод произведения элементов массива\n---------------------------------------");
        int[] intArrProduct = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = 1;
        for (int i = 0; i < intArrProduct.length; i++) {
            intArrProduct[i] = i;
            result *= (intArrProduct[i] != 0 && intArrProduct[i] != 9 ? intArrProduct[i] : 1);
            System.out.print(intArrProduct[i] != 0 && intArrProduct[i] != 9 ? intArrProduct[i] + " * " : "");
        }
        System.out.print("\u0008\u0008" + "= " + result);
        System.out.println("\nЧисло 0 Индекс " + Arrays.binarySearch(intArrProduct, 0));
        System.out.println("Число 9 Индекс " + Arrays.binarySearch(intArrProduct, 9));

        System.out.println("\n3. Удаление элементов массива\n-----------------------------\n");
        int len = 15;
        float[] floatArr = new float[len];
        for (int i = 0; i < len; i++) { floatArr[i] = (float) Math.random(); }
        printArrayDouble(floatArr, "%8.5f", 8);
        System.out.println('\n');
        float middleNumber = floatArr[len / 2];
        int zeroNumbersCount = 0;
        for (int i = 0; i < len; i++) {
            if (floatArr[i] > middleNumber) {
                floatArr[i] = 0;
                zeroNumbersCount++;
            }
        }
        printArrayDouble(floatArr, "%8.5f", 8);
        System.out.println("\n\nКоличество обнулённых яеек " + zeroNumbersCount);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке\n------------------------------------------------------");
        int charsCount = 'Z' - 'A' + 1;
        char[] chars = new char[charsCount];
        for (int i = 0; i < charsCount; i++) { chars[i] = (char) ('A' + i); }
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
        int[] intArrRandom = new int[len];
        for (int i = 0; i < len; i++) {
            intArrRandom[i] = 60 + random.nextInt(41);
            for (int j = 0; j < i; j++) {
                if (intArrRandom[j] == intArrRandom[i]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(intArrRandom);
        printArrayInt(intArrRandom, "%4d", 10);

        System.out.println("\n\n6. Сдвиг элементов массива\n-----------------------------");
        String[] src = {"", "AA", "", "", "BBB", "C", "", "DDDD"};
        len = src.length;
        int dstCount = len;
        for (int i = 0; i < len; i++) { if (src[i].isBlank()) { dstCount--; } }
        String[] dst = new String[dstCount];
        int dstPos = 0;
        int numStrings = 0;
        for (int i = 0; i < len; i++) {
            boolean isEmpty = src[i].isBlank();
            boolean isEnd = i == (len - 1);
            if (!isEmpty) { numStrings++; }
            if ((isEmpty || isEnd) && numStrings > 0) {
                int srcPos = i - numStrings + (isEnd ? 1 : 0);
                System.arraycopy(src, srcPos, dst, dstPos, numStrings);
                if (!isEnd) {
                    dstPos += numStrings;
                    numStrings = 0;
                }
            }
        }
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dst));
    }

    private static void printArrayInt(int[] ints) {
        for (int num : ints) { System.out.print(num + " "); }
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

    private static void printArrayDouble(float[] doubles, String fString, int fCols) {
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
    }
}
