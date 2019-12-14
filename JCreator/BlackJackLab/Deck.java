/* BlackJack Lab 
 * Deck
 * John Luke Denny
 */  

package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

import BlackJack.Card;

public class Deck{

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck(){
		//initialize data
		stackOfCards = new ArrayList<Card>();
		
		//populate stackOfCards with new cards
		for(String s:SUITS){
			for(int j = 1; j <= 13; j++){
				stackOfCards.add(new BlackJackCard(j, s));
			}
		}
		shuffle();

	}

	//mutators
   	public void shuffle(){

		Collections.shuffle(stackOfCards);
		topCardIndex = stackOfCards.size() - 1;
	}

   	//accessors
	public int size(){
		return stackOfCards.size();
	}

	public int numCardsLeft(){
		return topCardIndex + 1;
	}

	public Card nextCard(){
		return stackOfCards.get(topCardIndex--);
	}

	public String toString(){
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	}
}
