package novi.blackjack;

public class Player {
Hand hand;
private boolean isStaying = false;
    public Player () {
this.hand = new Hand();
    }
    public void performMove (Deck deck, String move) {
        if(move.equals("hit")) {
            Card card = deck.getNextCard();
            Card[] cardForPlayer = new Card[]{card};
            this.addCardsToHand(cardForPlayer);
            System.out.println("You were hit with:" + card.render());
        } else {
            isStaying = true;
        }
    }

    public void addCardsToHand(Card[] cards) {
        for (Card card : cards) {
            hand.addCard(card);
        };
    }
    public boolean isStaying () {
        return isStaying;
    }
    public boolean isBust () {
        return hand.getTotalValue()>21;
    }
    public int getHandValue () {
        return hand.getTotalValue();
    }
    public String renderHand () {
        return hand.render();
    }
}
