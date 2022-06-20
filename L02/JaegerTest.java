public class JaegerTest {

    public static void main(String[] args) {
        Jaeger jaeger1 = new Jaeger();
        jaeger1.setModelName("Bracer Phoenix");
        jaeger1.setMark("Mark-5");
        jaeger1.setOrigin("USA");
        jaeger1.setHeight(70.7f);
        jaeger1.setWeight(2.1f);
        jaeger1.setStrength(8);
        jaeger1.setArmor(9);
        jaeger1.setWeapons("Vortex Cannon", "Anti-Kaiju Missile", "Launcher",
                "M-19 Morning Star");
        jaeger1.setPilots("Viktoriya Malikova", "Ou-Yang Jinhai", "Amara Namani");

        System.out.println("\n\'" + jaeger1.modelName + "\' is testing methods:");
        boolean isDrifting = jaeger1.drift();
        int i = 0;
        while (isDrifting) {
            System.out.print("Drift-" + i + " : ");
            if (i == 5) {
                isDrifting = jaeger1.stopDrift();
                System.out.println("Stop drift");
            }
            i++;
        }
        jaeger1.move();
        jaeger1.scanKaiju();
        jaeger1.useVortexCannon();
        jaeger1.strike();
        jaeger1.roll();
        
        Jaeger jaeger2 = new Jaeger("Crimson Typhon");

        System.out.println("\n\'" + jaeger2.modelName + "\' is testing methods:");
        jaeger2.drift();
        System.out.println("Now is drifting");
        jaeger2.stopDrift();
        System.out.println("Now has stopped drifting");
        jaeger2.move();
        jaeger2.scanKaiju();
        jaeger2.useVortexCannon();
        jaeger2.strike();
        jaeger2.roll();
    }
}