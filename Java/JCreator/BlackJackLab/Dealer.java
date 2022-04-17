/* BlackJack Lab 
 * Dealer
 * John Luke Denny
 */ 

package BlackJack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import BlackJack.Card;
import BlackJack.Deck;
import BlackJack.AbstractPlayer;

public class Dealer extends AbstractPlayer{
	
	private Deck deckOfCards;

	//constructors
	public Dealer(){
		deckOfCards = new Deck();
	}

	//shuffle
	public void shuffle(){
		deckOfCards.shuffle();
	}

	//deal Card method
	public Card deal(){
		return deckOfCards.nextCard();
	}


	public boolean hit(){
	   	return getHandValue() < 17;
   	}
   
   	public int numCardsLeftInDeck(){
   		return deckOfCards.size();
   	}
}