package novi.blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotalValue() {
        int total = 0;
        for (Card card : cards) {
            total += card.getValue().getValue();
        }
        return total;
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.render());
            sb.append("\n");
        }
        return sb.toString();
    }

}
