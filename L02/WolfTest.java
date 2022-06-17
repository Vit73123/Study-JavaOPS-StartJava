public class WolfTest {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.name = "Фунтик";
        wolf.gender = 'М';
        wolf.weight = 38.5f;
        wolf.age = 15;
        wolf.colour = "серый";

        System.out.println("Волк\n----\n" +
                "Имя: " + wolf.name + '\n' +
                "Пол: " + wolf.gender + '\n' +
                "Вес: " + wolf.weight + '\n' +
                "Возраст: " + wolf.age + '\n' +
                "Окрас: " + wolf.colour+ '\n');
        wolf.go();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}