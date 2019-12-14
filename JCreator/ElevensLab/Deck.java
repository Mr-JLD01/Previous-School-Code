/* Elevens Lab - Deck Class
 * John Luke Denny
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
 
public class Deck {
	private List<Card> cards;
	private int top;
	
	public Deck(String[] ranks, String[] suits, int[] pValues){
		cards = new ArrayList<Card>();
		for(String suit : suits){
			for(int j = 0; j < ranks.length; j++){
				cards.add(new Card(ranks[j], suit, pValues[j]));
			}
		}
		shuffle();
	}
	
	public int cardsLeft(){
		return top + 1;
	}

	public int size(){
		return cards.size();	
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
		top = cards.size() - 1;
	}
	
	public Card deal(){
		if(isEmpty())
			return null;
		return cards.get(top--);
		
	}
	
	public String toString(){
		String dealt = "";
		String undealt = "";
		for(int k = 0; k < cards.size(); k++){
			if(k > top)
				dealt += cards.get(k).toString();
			else
				undealt += cards.get(k).toString();	
		}
		return "Dealt Cards: \n" + dealt + "Number of Undealt Cards: " + (top + 1) + "\n" + "Undealt Cards: \n" + undealt;	
	}
}