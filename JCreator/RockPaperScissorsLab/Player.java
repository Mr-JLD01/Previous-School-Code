/*Player class 
 *John Luke Denny
 *REPRINT
 */

public class Player{
	
	// instance variables
	private String name;
	private String choice;

	public Player(){
		//default constructor
		this("predictable", "rock");
	}

	public Player(String nm){
		//constructor with name argument
		this(nm, "rock");
		
	} 	
	
	public Player(String nm, String ch){
		//constructor with both arguments
		name = nm;
		choice = ch;	
	} 
		
	public void setName( String nm){
		//set player name
		name = nm;	
	}	
		
	public String getName(){
		//returns the name
		return name;
	}	
		
	public void setChoice( String ch ){
		//	set the choice of the player
		choice = ch;	
	}	
		
	public String getChoice(){
		//returns the player choice
		return choice;
	}	
		
	public String toString(){
		// return player + choice
		return name + " had " + choice;
	}
}