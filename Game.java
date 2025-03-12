package OIBSIP;
import java.util.Scanner;

public class Game {
    private int randomNumber;
    private int maxAttempts;
    private int attempts;
    private boolean isGameOver;

    public Game(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        resetGame();
    }

    public void resetGame() {
        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        isGameOver = false;
    }

    public boolean playTurn(Player player) {
        if (isGameOver) {
            System.out.println("Game is already over! Restarting...");
            resetGame();
        }

        System.out.print("Enter your guess: ");
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        attempts++;

        if (guess == randomNumber) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            player.addScore(100 - (attempts * 10));
            isGameOver = true;
            return true;
        } else if (guess < randomNumber) {
            System.out.println("Too low! Try again.");
        } else {
            System.out.println("Too high! Try again.");
        }

        if (attempts >= maxAttempts) {
            System.out.println("Game Over! The correct number was: " + randomNumber);
            isGameOver = true;
        }

        return false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}

