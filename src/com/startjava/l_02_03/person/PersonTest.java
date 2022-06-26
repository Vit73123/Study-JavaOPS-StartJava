package com.startjava.l_02_03.person;

public class PersonTest {
    
    public static void main(String[] args) {

        Person person = new Person();

        person.go(2);
        person.sit(1);
        person.run(3);
        person.speak("Привет");
        person.learnJava();
    }
}