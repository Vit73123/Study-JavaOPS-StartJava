package com.startjava.l_01.base;

import java.util.Scanner;

public class MyFirstApp {
    public static void main(String[] args) {
        System.out.println("Write once, run anywhere");
        System.out.println("Напиши однажды, запускай везде");
        Scanner console = new Scanner(System.in, "windows-1251");
        System.out.print("Введите своё имя: ");
        System.out.println(console.nextLine());
    }
}