package com.startjava.l_04;

import java.util.Arrays;
import java.util.Random;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Реверс значений массива\n--------------------------");
        int srcCount = 7;
        int[] numbersEx1 = new int[srcCount];
        for (int i = 0; i < srcCount; i++) {
            numbersEx1[i] = i + 1;
        }
        for (int num : numbersEx1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int iFirst = 0; iFirst < srcCount / 2; iFirst++) {
            int iLast = srcCount - iFirst - 1;
            int numTemp = numbersEx1[iFirst];
            numbersEx1[iFirst] = numbersEx1[iLast];
            numbersEx1[iLast] = numTemp;
        }
        for (int num : numbersEx1) {
            System.out.print(num + " ");
        }

        System.out.println("\n\n2. Вывод произведения элементов массива\n---------------------------------------");
        srcCount = 10;
        int[] numbersEx2 = new int[srcCount];
        int result = 1;
        for (int i = 0; i < srcCount; i++) {
            numbersEx2[i] = i;
            result *= (numbersEx2[i] != 0 && numbersEx2[i] != 9 ? numbersEx2[i] : 1);
            System.out.print(numbersEx2[i] != 0 && numbersEx2[i] != 9 ? numbersEx2[i] + " * " : "");
        }
        System.out.print("\u0008\u0008" + "= " + result);
        System.out.println("\nЧисло 0 Индекс " + Arrays.binarySearch(numbersEx2, 0));
        System.out.println("Число 9 Индекс " + Arrays.binarySearch(numbersEx2, 9));

        System.out.println("\n3. Удаление элементов массива\n-----------------------------");
        srcCount = 15;
        float[] numbersEx3 = new float[srcCount];
        for (int i = 0; i < srcCount; i++) {
            numbersEx3[i] = (float) Math.random();
            if (i == 8) { System.out.println(); }
            System.out.printf("%8.5f", numbersEx3[i]);
        }
        System.out.println('\n');
        float middleNumber = numbersEx3[srcCount / 2];
        int zeroNumbersCount = 0;
        for (int i = 0; i < srcCount; i++) {
            if (numbersEx3[i] > middleNumber) {
                numbersEx3[i] = 0;
                zeroNumbersCount++;
            }
            if (i == 8) { System.out.println(); }
            System.out.printf("%8.5f", numbersEx3[i]);
        }
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
        srcCount = 30;
        int[] numbersEx5 = new int[srcCount];
        for (int i = 0; i < srcCount; i++) {
            numbersEx5[i] = 60 + random.nextInt(41);
            for (int j = 0; j < i; j++) {
                if (numbersEx5[j] == numbersEx5[i]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(numbersEx5);
        int jCount = 0;
        for (int num : numbersEx5) {
            System.out.printf("%4d", num);
            jCount++;
            if (jCount == 10) {
                jCount = 0;
                System.out.println();
            }
        }
    }
}
