/* Runs class GuessingGame
 *John Luke Denny
 */
 
 import java.util.Scanner;
 
public class GuessRunner {
	public static void main(String[] args){
		System.out.println("John Luke Denny");
		
		Scanner input = new Scanner(System.in);
		char response;
		
		do{
			System.out.print("Guessing Game - How many numbers? ");
			GuessingGame game = new GuessingGame(input.nextInt());
			game.playGame();
			System.out.print("Do you want to play again? ");
			response = input.next().charAt(0);
			
		}while(response == 'y' || response == 'Y');
	}
}
