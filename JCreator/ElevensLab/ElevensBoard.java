/* Elevens Lab - Elevens Board class
 * D Frederick
 */

import java.util.List;
import java.util.ArrayList; 

public class ElevensBoard extends Board {
	
	private static final int BOARD_SIZE = 9;
	private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", 
											"8", "9", "10", "jack", "queen", "king"};
	private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	
	
	public ElevensBoard(){
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}
	
	private boolean containsPairSum11(List<Integer> selectedCards){
		for(int i = 0; i < selectedCards.size() - 1; i++){
			int card1 = selectedCards.get(i).intValue();
			for(int j = i + 1; j < selectedCards.size(); j++){
				int card2 = selectedCards.get(j).intValue();
				if(cardAt(card1).getPointValue() + cardAt(card2).getPointValue() == 11)
					return true;
			}
		}
		
		return false;	
	}
	
	private boolean containsJQK(List<Integer> selectedCards){
		boolean foundJack = false;
		boolean foundQueen = false;
		boolean foundKing = false;
		
		for(Integer kObj : selectedCards){
			int k = kObj.intValue();
			if(cardAt(k).getRank().equals("jack")){
				foundJack = true;
			}else if(cardAt(k).getRank().equals("queen")){
				foundQueen = true;
			}else if(cardAt(k).getRank().equals("king")){
				foundKing = true;
			}	
		}
		return foundJack && foundQueen && foundKing;
	}
	
	public boolean isLegal(List<Integer> selectedCards){
		if(selectedCards.size() == 2)
			return containsPairSum11(selectedCards);
		else if(selectedCards.size() == 3)
			return containsJQK(selectedCards);
		else 
			return false;
	}
	
	public boolean anotherPlayIsPossible(){
		return containsJQK(cardIndexes()) || containsPairSum11(cardIndexes());
	}
	
}
