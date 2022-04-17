/*Player runner
 *John Luke Denny
 */

public class PlayerRunner{
	
	public static void main(String[] args){
		
		Player s = new Player("Michael Jackson", "rock");

		System.out.println(s.getChoice());				//outs rock
		//call the getName() method 
		System.out.println(s.getName());				//outs Michael Jackson
		System.out.println(s);							//outs Michael Jackson rock
		
		//set the choice to paper
		s.setChoice("paper");
		System.out.println(s);							//outs Michael Jackson paper	
		
		//instantiate a new Player named Jim Bob that chose scissors
		Player j = new Player("Jim Bob", "scissors");
		//print out Jim Bob	
		System.out.println(j);
	}
}





