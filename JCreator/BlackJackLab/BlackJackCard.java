/* BlackJack Lab 
 * BlackJack Card
 * John Luke Denny
 */

package BlackJack;

public class BlackJackCard extends Card{
  	//constructors
  	public BlackJackCard(){
		super();
   	}

  	public BlackJackCard(int f, String s){
  	   	super(f,s);
  	}

 	public BlackJackCard(int f, String s, int wid, int ht){
  	   	//set instance variables to parameter values
  	   	//intialize all instance variables
  	   	super(f, s, wid, ht);
  	 	
  	}
  	
  	
  	

  	public int getValue(){
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier
		if(getFace() == 1)
			return 11;
		
		if(getFace() >= 10)
			return 10;
		
		return getFace();
  	}
}