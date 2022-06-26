package com.startjava.l_02_03.animal;

public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setName("Фунтик");
        wolf.setGender('М');
        wolf.setWeight(38.5f);
        wolf.setAge(15);
        wolf.setColour("серый");

        System.out.println("Волк\n----\n" +
                "Имя: " + wolf.getName() + '\n' +
                "Пол: " + wolf.getGender() + '\n' +
                "Вес: " + wolf.getWeight() + '\n' +
                "Возраст: " + ((wolf.getAge() > 0) ? wolf.getAge() : "Ошибка\n") +
                "Окрас: " + wolf.getColour() + '\n');
        wolf.go();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}