/*Finds a student average grade
 *John Luke Denny
 */
 
 import java.util.Scanner;
 import java.io.File;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.io.FileWriter;
 
public class Average {
	
	public static void main(String[] args) throws IOException{
		
		Scanner fileIn = new Scanner(new File("Grades.csv"));
		PrintWriter fileOut = new PrintWriter(new FileWriter("Gradebook.csv"));
		
		fileIn.useDelimiter(",");
		
		Scanner chop = new Scanner(fileIn.nextLine());
		int numData = chop.nextInt();
		fileOut.println(numData);
		System.out.println("John Luke Denny");
		
		for(int i = 1; i <= numData; i++){
			chop = new Scanner(fileIn.nextLine());
			chop.useDelimiter(",");
			int sum = 0;
			int count = 0;
			int min = Integer.MAX_VALUE;
			int score = 0;
			String name = chop.next();
			fileOut.print(name);
			while(chop.hasNextInt()){
				score = chop.nextInt();
				sum += score;
				count++;
				min = Math.min(score, min);
				fileOut.print("," + score);
				System.out.print(score + " ");
			}
			System.out.print("\n\n" + name + "'s average = ");
			
			double avg = (double)(sum - min)/ (count - 1);
			System.out.printf("%.2f%n", avg);
			System.out.print("\n");
			fileOut.printf(",%.2f%n", avg);
		}
		fileOut.close();
	}
}
