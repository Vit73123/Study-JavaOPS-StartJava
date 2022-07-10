package com.startjava.l_04;

import java.util.Arrays;

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
    }
}
