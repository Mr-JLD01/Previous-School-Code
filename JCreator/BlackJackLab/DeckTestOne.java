/* BlackJack Lab 
 * DeckTestOne
 */ 

import java.awt.Color;

import BlackJack.Card;
import BlackJack.BlackJackCard;
import BlackJack.Deck;

public class DeckTestOne{
	
	public static void main(String[] args){
		Deck deck = new Deck();	
		for(int i = 0; i < deck.size(); i++){
		  	System.out.println(deck.nextCard());
		}
		
		System.out.println("\n\n");
		
		System.out.println("num cards left in the deck == " + deck.numCardsLeft());
		
		System.out.println("\n\nshuffling");
		deck.shuffle();
		System.out.println("num cards left in the deck == " + deck.numCardsLeft());
		
		
		System.out.println("\n\ntoString");
		System.out.println(deck);							
	}
}