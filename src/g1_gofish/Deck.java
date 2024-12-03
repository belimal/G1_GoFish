// @author: Alshifa Belim, Carlo Maximo, Palakpreet Kaur
// Final ver.

package g1_gofish;

import java.util.ArrayList;

// Deck class
public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                // Used CardFactory to create the cards
                deck.add(CardFactory.createCard(rank, suit));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int j = (int) (Math.random() * deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public Card deal() {
        if (!deck.isEmpty()) {
            Card card = deck.get(0);
            deck.remove(0);
            return card;
        }
        return null;
    }

    public boolean isEmpty() {
        if (deck.isEmpty()) {
                return true;
        }
        return false;
    }
}