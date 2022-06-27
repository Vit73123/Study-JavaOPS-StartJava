package com.startjava.l_02_03.robot;

public class JaegerTest {

    public static void main(String[] args) {
        Jaeger bracerPhoenix = new Jaeger();
        bracerPhoenix.setModelName("Bracer Phoenix");
        bracerPhoenix.setMark("Mark-5");
        bracerPhoenix.setOrigin("USA");
        bracerPhoenix.setHeight(70.7f);
        bracerPhoenix.setWeight(2.1f);
        bracerPhoenix.setStrength(8);
        bracerPhoenix.setArmor(9);
        bracerPhoenix.setWeapons("Vortex Cannon", "Anti-Kaiju Missile", "Launcher",
                "M-19 Morning Star");
        bracerPhoenix.setPilots("Viktoriya Malikova", "Ou-Yang Jinhai", "Amara Namani");

        System.out.println("\n'" + bracerPhoenix.modelName + "':");
        System.out.println(bracerPhoenix.toString() + '\n');
        System.out.println("Testing methods:");
        boolean isDrifting = bracerPhoenix.drift();
        int i = 0;
        while (isDrifting) {
            System.out.print("Drift-" + i + " : ");
            if (i == 5) {
                isDrifting = bracerPhoenix.stopDrift();
                System.out.println("Stop drift");
            }
            i++;
        }
        bracerPhoenix.move();
        System.out.println(bracerPhoenix.scanKaiju());
        bracerPhoenix.useVortexCannon();
        bracerPhoenix.strike();
        bracerPhoenix.roll();
        
        Jaeger crimsonTyphon = new Jaeger("Crimson Typhon");

        System.out.println("\n'" + crimsonTyphon.modelName + "':");
        System.out.println(crimsonTyphon.toString() + '\n');
        System.out.println("Testing methods:");
        crimsonTyphon.drift();
        System.out.println("Now is drifting");
        crimsonTyphon.stopDrift();
        System.out.println("Now has stopped drifting");
        crimsonTyphon.move();
        System.out.println(crimsonTyphon.scanKaiju());
        crimsonTyphon.useVortexCannon();
        crimsonTyphon.strike();
        crimsonTyphon.roll();
    }
}