/* Celsius converter
 **John Luke Denny
 */
 
 import java.util.Scanner;
 
public class Celsius {
	public static void main (String[] args){
		System.out.println("Enter celsius temperature.");
		Scanner keyboard = new Scanner(System.in);
		int celsius = keyboard.nextInt();
		double fahrenheit;
		fahrenheit = 9.0 / 5.0 * celsius + 32.0;
		System.out.println("The Fahrenheit temperature is..." + fahrenheit + "!");
		
	}	
}
