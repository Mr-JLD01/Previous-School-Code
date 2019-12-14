/* Elevens Lab - Board class
 * John Luke Denny
 */

import java.util.List;
import java.util.ArrayList;
 
public abstract class Board {
	
	private Deck deck;
	private Card[] cards;
	
	private static final boolean DEBUGGING = false;
	
	public Board(int size, String[] ranks, String[] suits, int[] pValues){
		cards = new Card[size];
		deck = new Deck(ranks, suits, pValues);
		if(DEBUGGING)
			System.out.println(deck + "----------");
		dealMyCards();	
	}
	
	public void newGame(){			// resets board
		deck.shuffle();
		dealMyCards();
	}
	
	public int size(){				// how many cards are on the board
		return cards.length;
	}
	
	public int deckSize(){			// number of undealt cards
		return deck.cardsLeft();
	}
	
	public Card cardAt(int k){		// card at a specific location
		return cards[k];
	}
	
	public boolean isEmpty(){		// true if board is empty
		for(int k = 0; k < cards.length; k++){
			if(cards[k] != null)
				return false;		
		}
		return true;
	}
	
	public void deal(int k){		// deals one card to a specific location
		cards[k] = deck.deal();
	}
	
	public void replaceSelectedCards(List<Integer> selectedCards){
		for(Integer k : selectedCards){
			deal(k.intValue());
		}
	}
	
	public List<Integer> cardIndexes(){
		List<Integer> selected = new ArrayList<Integer>();
		for(int k = 0; k < cards.length; k++){
			if(cards[k] != null)
				selected.add(new Integer(k));		
		}
		return selected;
	}
	
	public String toString(){
		String output = "";
		for(int k = 0; k < cards.length; k++){
			output += k + ": " + cards[k];
		}
		return output;
	}
	
	private void dealMyCards(){
		for(int k = 0; k < cards.length; k++)
			cards[k] = deck.deal();
	}
	
	public boolean gameIsWon(){
		return isEmpty() && deck.isEmpty();
	}
	
	public abstract boolean isLegal(List<Integer> selectedCards);
	
	public abstract boolean anotherPlayIsPossible();
}
