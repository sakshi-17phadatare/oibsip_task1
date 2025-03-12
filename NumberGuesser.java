package OIBSIP;
import java.util.Scanner;

public class NumberGuesser {
    private Player player;
    private Game game;
    private int totalRounds;

    public NumberGuesser(Player player, int totalRounds, int maxAttempts) {
        this.player = player;
        this.totalRounds = totalRounds;
        this.game = new Game(maxAttempts);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        
        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\n--- Round " + round + " ---");
            game.resetGame();

            while (!game.isGameOver()) {
                game.playTurn(player);
            }
            
            System.out.println("Round " + round + " Over!");
            player.displayScore();

            if (round < totalRounds) {
                System.out.print("Do you want to continue to the next round? (yes/no): ");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("\nGame Over! Final Score: " + player.getScore());
    }
}
