/* BlackJack Lab PlayerTestOne
 */ 

import java.awt.Color;

import BlackJack.Card;
import BlackJack.BlackJackCard;
import BlackJack.Deck;
import BlackJack.AbstractPlayer;
import BlackJack.Player;

public class PlayerTestOne{
	
	public static void main(String[] args){
		Player player = new Player();	
		
		Deck deck = new Deck();
		deck.shuffle();
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		System.out.println("\n\ntoString");
		System.out.println(player);	
		
		System.out.println("\n\nhandValue");
		System.out.println(player.getHandValue());					
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		System.out.println("\n\ntoString");
		System.out.println(player);	
		
		System.out.println("\n\nhandValue");
		System.out.println(player.getHandValue());									
	}
}