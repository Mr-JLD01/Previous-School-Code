
/* Code for guessing a number
 *John Luke Denny
 */
 
 import java.util.Scanner;
 
public class GuessingGame {
	private int upperBound;
	
	public GuessingGame(){
		this(1);
	}
	
	public GuessingGame(int up){
		upperBound = up;
	}
	
	public void setBound(int up){
		upperBound = up;
	}
	
	public int getBound(){
		return upperBound;
	}
	
	public void playGame(){
		Scanner input = new Scanner(System.in);
		int target = (int) (Math.random() * upperBound) + 1;
		int guess;
		int guessCount = 0;
		double percent;
		do{
			System.out.print("Enter a number between 1 and " + upperBound + ":: ");
			guess = input.nextInt();
			if(guess > upperBound || guess < 1){
				System.out.println("Number out of range!");
			}
			else{
			guessCount++;
			}
		}while(!(target == guess));
		percent = (((double)guessCount - 1) / (double)guessCount) * 100;
		System.out.println("\nIt took " + guessCount + " guesses to guess " + target + ".\nYou guessed wrong " + String.format("%.2f", percent) + " percent of the time.\n\n\n");
	}
	
	public String toString(){
		return "The upperbound is " + upperBound;
	}
}
