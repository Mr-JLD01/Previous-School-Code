/* Runs class quadratic
 *John Luke Denny
 */
 
 import java.util.Scanner;
 
public class QuadraticRunner {
	public static void main(String[] args){
		double a, b, c;
		System.out.println("John Luke Denny");
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a number \"a\" :: ");
		a = keyboard.nextDouble();
		
		System.out.print("Enter a number \"b\" :: ");
		b = keyboard.nextDouble();
		
		System.out.print("Enter a number \"c\" :: ");
		c = keyboard.nextDouble();
		
		Quadratic roots = new Quadratic(a, b, c);
		
		System.out.println("\n" + roots.toString());
		
		System.out.print("Enter a number \"a\" :: ");
		a = keyboard.nextDouble();
		
		System.out.print("Enter a number \"b\" :: ");
		b = keyboard.nextDouble();
		
		System.out.print("Enter a number \"c\" :: ");
		c = keyboard.nextDouble();
		
		roots.setNum(a, b, c);
		
		System.out.println("\n" + roots.toString());
		
		System.out.print("Enter a number \"a\" :: ");
		a = keyboard.nextDouble();
		
		System.out.print("Enter a number \"b\" :: ");
		b = keyboard.nextDouble();
		
		System.out.print("Enter a number \"c\" :: ");
		c = keyboard.nextDouble();
		
		roots.setNum(a, b, c);	
		
		System.out.println("\n" + roots.toString());
	}
}
