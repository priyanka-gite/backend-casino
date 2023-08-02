package novi.higherlower;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        gameIsRunning = true;
        Random random = new Random();
        int number = random.nextInt(101);
        System.out.println(number); //remove later

        int totalTurns = 0;
        while (gameIsRunning) {
            totalTurns = totalTurns + 1;
            System.out.println("Make a guess");

            var input = inputScanner.nextInt();//blocking call
            System.out.printf("You typed: %s\n", input);

            if (input == number) {
                gameIsRunning = false;
                System.out.printf("You guessed it correctly in : %s turns", totalTurns);
            } else if (input > number) {
                System.out.println("That number is too high");
            } else if (input < number) {
                System.out.println("That number is too low");
            }
        }
    }
}
