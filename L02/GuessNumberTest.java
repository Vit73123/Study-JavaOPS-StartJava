import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "cp866");

        System.out.print("\nВведите имя игрока 1: ");
        Player player1 = new Player(scan.nextLine());
        System.out.print("Введите имя игрока 2: ");
        Player player2 = new Player(scan.nextLine());
        GuessNumber guessNumber = new GuessNumber(player1, player2);

        String yesNo = "yes";
        do {
            if (yesNo.equals("yes")) {
                guessNumber.play();
                System.out.print("\nНовая игра? ");
                yesNo = scan.nextLine();
            }
        } while (!yesNo.equals("no"));
    }
}