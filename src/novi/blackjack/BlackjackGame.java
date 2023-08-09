package novi.blackjack;

import java.util.Scanner;

public class BlackjackGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackjackGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck.shuffle();
        Card[] cardsForPlayer = new Card[]{deck.getNextCard(), deck.getNextCard()};
        player.addCardsToHand(cardsForPlayer);
        Card[] cardsForDealer = new Card[]{deck.getNextCard()};
        dealer.addCardsToHand(cardsForDealer);

    }

    public void renderAllHands() {
        System.out.println("These are your cards: ");
        System.out.println(player.renderHand());
        System.out.println("These are dealer cards: ");
        System.out.println(dealer.renderHand());
    }

    public void playGame() {
        gameIsRunning = true;
        System.out.println("Welcome to Blackjack game");
        while (gameIsRunning) {
            renderAllHands();
            if(!player.isStaying() && !dealer.isStaying()) {
                System.out.println("Do you want to hit or stay?");
                String hitOrStay = inputScanner.nextLine();
                if(hitOrStay.equals("hit") || hitOrStay.equals("stay")){

                    player.performMove(deck, hitOrStay);
                    if (player.isBust()) {
                        System.out.println("You have lost!");
                        System.out.println("Your hand value is: " + player.getHandValue());
                        gameIsRunning = false;
                    }

                    dealer.performMove(deck);
                    if(dealer.isBust()){
                        System.out.println("You have won!");
                        renderAllHands();
                    }

                } else {
                    System.out.println("Wrong input, try again");
                }
            } else {
                if(player.getHandValue() <= dealer.getHandValue()){
                    System.out.println("You have lost!");
                    renderAllHands();
                }
                if(dealer.getHandValue() < player.getHandValue()){
                    System.out.println("You have won!");
                    renderAllHands();
                }
                gameIsRunning = false;}
    }
}
}
