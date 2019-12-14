/* Elevens Lab - Card class
 * John Luke Denny
 */
 
public class Card {
	private String rank;
	private String suit;
	private int pointValue;
	
	public Card(String r, String s, int v){
		rank = r;
		suit = s;
		pointValue = v;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public String getRank(){
		return rank;
	}
	
	public int getPointValue(){
		return pointValue;
	}
	
	public boolean matches(Card other){
		return other.getSuit().equals(suit) && other.getRank().equals(rank) && other.getPointValue() == pointValue;
	}
	
	public String toString(){
		
		return rank + " of " + suit + " (point value = " + pointValue + ")\n";
	}
}
