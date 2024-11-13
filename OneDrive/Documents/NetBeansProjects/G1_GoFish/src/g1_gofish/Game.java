// @author: Alshifa Belim, Carlo Maximo, Palakpreet Kaur
package g1_gofish;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Game rules and logic
public class Game {
    private ArrayList<Player> players;
    public Deck deck;
    private int numPlayers = 2;
    private ArrayList<Card> discards;

    public boolean allPlayersHaveCards() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public Game() {
        Scanner in = new Scanner(System.in);
        players = new ArrayList<Player>();
        deck = new Deck();
        deck.shuffle();
        discards = new ArrayList<Card>();


        // Create player profile
        System.out.println("Enter your name: ");
        String name = in.nextLine();
        players.add(new Player(name));
        players.add(new Player("Computer"));

        // Deal cards
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.addCard(deck.deal());
            }
        }
        // Play game
        while ((deck.deal() != null) && (allPlayersHaveCards())) {
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn");
                System.out.println("Your hand: ");
                player.getHand().forEach(card -> System.out.println(card.getRank() + " of " + card.getSuit()));

                System.out.println("Which player do you want to ask for a card? ");
                for (int i = 0; i < players.size(); i++) {
                    System.out.println(i + ": " + players.get(i).getName());
                }
                int playerIndex = in.nextInt();

                System.out.println("Ask a player for a card: ");
                String rank = in.nextLine();
                player.askForCard(players.get(playerIndex), Card.Rank.valueOf(rank), deck);
            }
        }
    }
    
}