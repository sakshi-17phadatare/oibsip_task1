package OIBSIP;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player(name);
        NumberGuesser game = new NumberGuesser(player, 3, 5); // 3 rounds, 5 attempts per round

        game.startGame();
    }
}

