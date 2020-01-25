/* BlackJack Lab 
 * DealerTestOne
 */  

import java.awt.Color;

import BlackJack.Card;
import BlackJack.BlackJackCard;
import BlackJack.Deck;
import BlackJack.AbstractPlayer;
import BlackJack.Player;
import BlackJack.Dealer;

public class DealerTestOne{
	
	public static void main(String[] args){
		//Code to test the Dealer
		Dealer dealer = new Dealer();
		Player player = new Player();
		
		dealer.shuffle();
		
		player.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
		player.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
		
		int playerTotal = player.getHandValue();
		int dealerTotal = dealer.getHandValue();
		
		System.out.println("\nPLAYER ");
		System.out.println("Hand Value :: " + playerTotal );
		System.out.println("Hand Size :: " + player.getHandSize() );
		System.out.println("Cards in Hand :: " + player.toString() );
		System.out.println("\nDEALER ");
		System.out.println("Hand Value :: " + dealerTotal );
		System.out.println("Hand Size :: " + dealer.getHandSize() );
		System.out.println("Cards in Hand :: " + dealer.toString() );
		
		if(playerTotal > 21 && dealerTotal <= 21){
		   	System.out.println("\nDealer wins - Player busted!");
		}
		else if(playerTotal <= 21 && dealerTotal > 21){
		   	System.out.println("\nPlayer wins - Dealer busted!");
		}
		else if(playerTotal > 21 && dealerTotal > 21){
		   	System.out.println("Both players bust!");
		}
		else if(playerTotal < dealerTotal){
		   	System.out.println("\nDealer has bigger hand value!");
		}
		else{
		   	System.out.println("\nPlayer has bigger hand value!");
		}					
	}
}