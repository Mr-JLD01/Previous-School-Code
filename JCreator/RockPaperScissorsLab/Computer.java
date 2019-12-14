/*Computer Class
 *John Luke Denny
 */ 

public class Computer{
	//instance variables
    private String choice;
   
	public Computer(){
		//call random set Choice
		randomSetChoice();	
	}
	
	public String getChoice(){
		return choice;
	}
	
	public void randomSetChoice(){
		//use Math.random()
		int rnd = (int)(Math.random() * 3);
		//use switch case
		switch(rnd){
			case 0 : choice = "rock"; break;
			case 1 : choice = "paper"; break;
			case 2 : choice = "scissors"; break;
			default: choice = "error";
		}
		
	}	
		
	/*
	 didIWin(Player p) will return the following values
	 	0 - both players have the same choice
	 	1 - the computer had the higher ranking choice
	 	-1 - the player had the higher ranking choice
	 */	
	public int didIWin(Player p){
		if(choice.equals(p.getChoice()))
			return 0;
		else if(choice.equals("paper") &&p.getChoice().equals("rock"))
			return 1;
		else if(choice.equals("rock") && p.getChoice().equals("scissors"))
			return 1;
		else if(choice.equals("scissors") && p.getChoice().equals("paper"))
			return 1;	
		else
			return -1;		
	}

	public String toString(){
		return "Bill Nye the Science Guy had " + choice;
	}		   
}