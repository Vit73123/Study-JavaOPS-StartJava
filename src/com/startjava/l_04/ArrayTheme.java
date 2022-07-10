package com.startjava.l_04;

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
    }
}
