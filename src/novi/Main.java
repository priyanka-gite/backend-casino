package novi;

import java.util.Scanner;

import novi.blackjack.BlackjackGame;


public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        BlackjackGame game = new BlackjackGame(inputScanner);

        game.playGame();
        System.out.println("game finished");
    }
}
