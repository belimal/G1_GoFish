// @author: Alshifa Belim, Carlo Maximo, Palakpreet Kaur
// Final ver.
// Implementation of the CardFactory class in accordance to the Factory design pattern

package g1_gofish;

public class CardFactory {
 public static Card createCard(Card.Rank rank, Card.Suit suit) {
     return new Card(rank, suit);
 }   
}