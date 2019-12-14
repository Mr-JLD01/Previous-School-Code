/* BlackJack Lab 
 * AbstractPlayer
 * John Luke Denny
 */
 
package BlackJack;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import BlackJack.Card;

public abstract class AbstractPlayer implements Playerable{
	
   	private ArrayList<Card> hand;
   	private int winCount;


   	public AbstractPlayer(){
   		this(0);
	
  	}

  	public AbstractPlayer(int score){
  		hand = new ArrayList<Card>();
		winCount = score;

   	}

   	public void addCardToHand(Card temp){
		hand.add(temp);
   	}

   	public void resetHand(){
      	hand.clear();
   	}

   	public void setWinCount(int numWins){
		winCount = numWins;
   	}

   	public int getWinCount(){ 
   		return winCount; 
   	}

   	public int getHandSize(){ 
   		return hand.size(); 
   	}

   	public ArrayList<Card> getHand(){
   		return hand;
   	}

   	public int getHandValue(){
		int sum = 0;
		for(Card c: hand)
			sum += c.getValue();
			
		for(Card b: hand){
			if(sum > 21){
				if(b.getFace() == 1)
						sum -= 10;
				}
			}
		
		return sum;
   	}

   	public String toString() {
      	return "hand = " + hand.toString() + " \n-  # wins " + winCount;
   	}

	public void drawHand(Graphics window, int x, int y){
		
		for(Card c : hand){
			c.setWidth(100);
			c.setHeight(140);
			c.drawCard(window,10 + x * 110, y);
			x++;
		}


	}
	public Card getCardFromHand(int pos){
		return hand.get(pos);
	}
	
	public abstract boolean hit();
}