/* Elevens Lab - ThirteensBoard class
 * D Frederick
 */

import java.util.List;
import java.util.ArrayList; 
 
public class ThirteensBoard extends Board {
	
		
	private static final int BOARD_SIZE = 10;
	private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", 
											"8", "9", "10", "jack", "queen", "king"};
	private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	
	
	public ThirteensBoard(){
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}
	
	private boolean containsPairSum13(List<Integer> selectedCards){
		for(int i = 0; i < selectedCards.size() - 1; i++){
			int card1 = selectedCards.get(i).intValue();
			for(int j = i + 1; j < selectedCards.size(); j++){
				int card2 = selectedCards.get(j).intValue();
				if(cardAt(card1).getPointValue() + cardAt(card2).getPointValue() == 13)
					return true;
			}
		}
		return false;
	}
	
	private boolean containsKing(List<Integer> selectedCards){
	
		boolean foundKing = false;
		
		for(Integer kObj : selectedCards){
			int k = kObj.intValue();
			if(cardAt(k).getRank().equals("king")){
				foundKing = true;
			}	
		}
		return foundKing;
	}
	
	
	public boolean isLegal(List<Integer> selectedCards){
			if(selectedCards.size() == 2)
			return containsPairSum13(selectedCards);
		else if(selectedCards.size() == 1)
			return containsKing(selectedCards);
		else 
			return false;
	}
	
	public boolean anotherPlayIsPossible(){
		return containsKing(cardIndexes()) || containsPairSum13(cardIndexes());
	}
	
}
