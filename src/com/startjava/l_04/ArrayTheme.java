package com.startjava.l_04;

import java.util.Arrays;
import java.util.Random;

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
        len = 10;
        intArr = new int[len];
        for (int i = 0; i < len; i++) intArr[i] = i;
        int result = 1;
        for (int i = 2; i < len - 1; i++) result *= intArr[i];
        for (int i = 0; i < len; i++) {
            System.out.print(i == 0 || i == 9 ? "\nЧисло " + intArr[i] + " индекс " + i + '\n' :
                    intArr[i] + (i < 8 ? " * " : " = " + result));
        }

        System.out.println("\n3. Удаление элементов массива\n-----------------------------\n");
        len = 15;
        int cols = 8;
        float[] floatArr = new float[len];
        for (int i = 0; i < len; i++) {
            floatArr[i] = (float) Math.random();
        }
        printArrayFloat(floatArr, "%8.5f", 8);
        double middleNum = floatArr[len / 2];
        int zeroNumCount = 0;
        for (int i = 0; i < len; i++) {
            if (floatArr[i] > middleNum) {
                floatArr[i] = 0;
                zeroNumCount++;
            }
        }
        printArrayFloat(floatArr, "%8.5f", 8);
        System.out.println("Количество обнулённых ячеек " + zeroNumCount);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке\n------------------------------------------------------");
        len = 'Z' - 'A' + 1;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) chars[i] = (char) ('A' + i);
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > len - 2 - i; j--) System.out.print(chars[j]);
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел\n-----------------------------");
        len = 30;
        intArr = new int[len];
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
        cols = 10;
        for (int i = 0; i < (len - 1) / cols + 1; i++) {
            int rowCols = (i + 1) * cols > len ? (i + 1) * cols - len : cols;
            int[] rowArr = new int[rowCols];
            System.arraycopy(intArr, i * cols, rowArr, 0, rowCols);
            printArrayInt(rowArr);
        }

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
        for (int num : ints) System.out.printf("%4d", num);
        System.out.println();
    }

    private static void printArrayFloat(float[] floats, String fString, int fCols) {
        fCols = fCols > 0 ? fCols : floats.length;
        int i = 0;
        for (float num : floats) {
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