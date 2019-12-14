/* runs Character Analyzer
 *John Luke Denny
 */
 
 import java.util.Scanner;
 
public class CharacterRunner {
	
	public static void main(String[] args){
		char ascii;
		System.out.println("John Luke Denny");
		
		Scanner keyboard = new Scanner(System.in);
		
		CharacterAnalyzer test = new CharacterAnalyzer();
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
		
		System.out.print("Enter character:: ");
		test.setChar(keyboard.next().charAt(0));
		System.out.print(test.toString());
	}
}
