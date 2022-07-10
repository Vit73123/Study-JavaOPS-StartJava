package com.startjava.l_02_03.person;

public class Person {
    char gender = 'М';
    String name = "Сергей";
    float height = 180F;
    float weight = 93.5F;
    int age = 23;

    void go(double distance) {
        System.out.println("Иду " + distance + " километров");
    }

    void sit(double time) {
        System.out.println("Сижу " + time + " часов");
    }

    void run(double distance) {
        System.out.println("Бегу " + distance + " километров");
    }

    void speak(String words) {
        System.out.println("Говорю " + words);
    }

    void learnJava() {
        System.out.println("Учу Java");
    }
}