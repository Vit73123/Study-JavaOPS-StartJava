import java.util.Scanner;

public class GuessNumber {
    private int min = 1;
    private int max = 100;
    private int targetNumber;
    private Player player1;
    private Player player2;

    public GuessNumber (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        String yesNo = "yes";

        targetNumber = min + (int) (Math.random() * max);
        do {
            if (yesNo.equals("yes") && (checkNumber(player1) || checkNumber(player2))) {
                yesNo = "no";
            }
        } while (!yesNo.equals("no"));

    }

    private boolean checkNumber(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.print(player.getName() + ", Ваше число? ");
        player.setNumber(scan.nextInt());
        if ((player.getNumber()) == targetNumber) {
            System.out.println(player2.getName() + ", Вы угадали!");
            return true;
        }
        if ((player.getNumber()) < targetNumber) {
            System.out.println("Число " + player.getNumber() +
                    " меньше того, что загадал компьютер");
        } else {
            System.out.println("Число " + player.getNumber() +
                    " больше того, что загадал компьютер");
        }
        return false;
    }
}