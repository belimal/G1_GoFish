// @author: Alshifa Belim, Carlo Maximo, Palakpreet Kaur
package g1_gofish;

import java.util.ArrayList;

// Player class
public class Player {
    // Player attributes
    private String name;
    private ArrayList<Card> hand;
    private Integer score;

    // Player constructor
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        score = 0;
    }

    // Player methods
    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void askForCard(Player player, Card.Rank rank, Deck deck) {
        boolean hasCard = false;
        for (Card card : player.hand) {
            if (card.getRank() == rank) {
                hand.add(card);
                player.hand.remove(card);
                return;
            }
        }
        if (!hasCard) {
            System.out.println("Go fish!");
            Card card = deck.deal();
            if (card != null) {
                hand.add(card);
            }
        }
    }

    public void hasFour() {
        for (Card.Rank rank : Card.Rank.values()) {
            int count = 0;
            ArrayList<Card> toRemove = new ArrayList<>();
            for (Card card : hand) {
                if (card.getRank() == rank) {
                    count++;
                    toRemove.add(card);
                }
            }
            if (count == 4) {
                for (Card card : toRemove) {
                    hand.remove(card);
                }
                score++;
            }
        }
    }
}
