/*Code to create loads of boxes
 *John Luke Denny
 */
 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
 
public class Box {
	public static void main(String[] args) throws IOException{
	
		Scanner file = new Scanner(new File("Box.dat"));
		System.out.println("John Luke Denny\n");
		int boxes = file.nextInt();
		file.nextLine();
		for(int i = 0; i < boxes; i++){
			String letter = file.next();
			int number = file.nextInt();
			makeBoxes(number, letter);
			file.nextLine();
		}
		
	}
	public static void makeBoxes(int number, String letter){
		int num = number;
		String let = letter;
		String square = "";
		//for(int j = 0; j < num; j++){
		//	for(int k = 0; k < num; k++){
		//		  square += let;
		//	}
		//	square += "\n";
		//}
	    //square += "\n\n";
		//System.out.print(square);
		
		for(int f = 0; f < num; f++){
			square += let;
		}
		square += "\n";
		String copy = square;
		for(int d = 0; d < num; d++){
			square += copy;
		}
		square += "\n\n";
		System.out.print(square);
	}
}
