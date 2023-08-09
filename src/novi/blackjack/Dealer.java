package novi.blackjack;

public class Dealer {
    Hand hand;
    private boolean isStaying = false;

    public Dealer() {
        this.hand = new Hand();
    }

    public void performMove(Deck deck) {
        if (hand.getTotalValue() < 17) {
            Card[] cardForPlayer = new Card[]{deck.getNextCard()};
            this.addCardsToHand(cardForPlayer);
        } else {
            isStaying = true;
        }
    }
        public void addCardsToHand (Card[]cards){
            for (Card card : cards) {
                hand.addCard(card);
            }
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
