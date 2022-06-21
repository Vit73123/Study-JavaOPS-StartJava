import java.util.Scanner;

public class GuessNumber {
    int min = 1;
    int max = 100;
    Player player1;
    Player player2;

    public GuessNumber (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        int targetNumber = min + (int) (Math.random() * max);

        System.out.println(targetNumber);

        System.out.print(player1.getName() + ", Ваше число? ");
        player1.setNumber(scan.nextInt());
        if ((player1.getNumber()) == targetNumber) {
            System.out.println(player1.getName() + ", Вы угадали!");
        } else {
            if ((player1.getNumber()) < targetNumber) {
                System.out.println("Число " + player1.getNumber() +
                        " меньше того, что загадал компьютер");
            } else {
                System.out.println("Число " + player1.getNumber() +
                        " больше того, что загадал компьютер");
            }
            System.out.print(player2.getName() + ", Ваше число? ");
            player2.setNumber(scan.nextInt());
            if ((player2.getNumber()) == targetNumber) {
                System.out.println(player2.getName() + ", Вы угадали!");
            } else if ((player1.getNumber()) < targetNumber) {
                System.out.println("Число " + player2.getNumber() +
                        " меньше того, что загадал компьютер");
            } else {
                System.out.println("Число " + player2.getNumber() +
                        " больше того, что загадал компьютер");
            }
        }
        System.out.println("Компьютер загадал число " + targetNumber);
    }
}