/*  Jaeger v1.1 220620
 *
 *  Поля Jaeger:
 *  String modelName;
 *  String mark;
 *  String origin;
 *  float height;
 *  float weight;
 *  int strength;
 *  int armor;
 *  String weapons;     Добавлен v 1.1
 *  int pilotsNumber;   Добавлен v 1.1
 *  String[] pilots;    Добавлен v 1.1
 *
 *  Методы Jaeger:
 *  boolean drift()
 *  boolean stopDrift()
 *  move()
 *  scanKaiju()
 *  useVortexCannon()
 *  strike()            Добавлен v 1.1
 *  roll()              Добавлен v 1.1 */

package com.startjava.l_02_03.robot;

public class Jaeger {
    public String modelName;
    public String mark;
    public String origin;
    public float height;
    public float weight;
    public int strength;
    public int armor;
    public String[] weapons;
    public String[] pilots;

    public Jaeger() {
    }

    public Jaeger(String modelName) {
        this.modelName = modelName;
        switch (modelName) {
            case "Crimson Typhon" :
                mark = "Mark-4";
                origin = "China";
                height = 76.2f;
                weight = 1.722f;
                strength = 8;
                armor = 6;
                weapons = new String[1];
                weapons[0] = "IB22 Plasmacaster";
                pilots = new String[3];
                pilots[0] = "Cheung Wei";
                pilots[1] = "Jin Wei";
                pilots[2] = "Hy Wei";
                break;
            default :
                break;
        }
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setWeapons(String... weapons) {
        this.weapons = new String[weapons.length];
        for (int i = 0; i < weapons.length; i++) {
            this.weapons[i] = weapons[i];
        }
    }

    public void setPilots(String... pilots) {
        this.pilots = new String[pilots.length];
        for (int i = 0; i < pilots.length; i++) {
            this.pilots[i] = pilots[i];
        }
    }

    public boolean drift() {
        return true;
    }

    public boolean stopDrift() {
        return false;
    }

    public void move() {
        System.out.println("moving");
    }

    public String scanKaiju() {
        return "scanning";
    }

    public void useVortexCannon() {
        System.out.println("activated");
    }

    public void strike() {
        System.out.println("striking");
    }

    public void roll() {
        System.out.println("rolling");
    }
}