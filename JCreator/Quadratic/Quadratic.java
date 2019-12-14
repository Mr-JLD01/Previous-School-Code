/* code for the quadratic formula
 *John Luke Denny
 */
 
 import java.util.Scanner;
 
public class Quadratic {
	private double a, b, c;
	Scanner keyboard = new Scanner(System.in);
	
	public Quadratic(){
		this(0, 0, 0);
	}
	
	public Quadratic(double aPrime, double bPrime, double cPrime){
		a = aPrime;
		b = bPrime;
		c = cPrime;	
	}	
	
	public void setA(double aPrime){
		a = aPrime;
	}	
	public void setB(double bPrime){
		b = bPrime;
	}	
	public void setC(double cPrime){
		c = cPrime;
	}	
	public void setNum(double aPrime, double bPrime, double cPrime){
		a = aPrime;
		b = bPrime;
		c = cPrime;
		}
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getC(){
		return c;
	}
	public double getPlus(){
		return ((-b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			
	}
	public double getMinus(){
		return ((-b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
	}

	public String toString(){
		
		
		return "rootOne :: " + String.format("%.2f",getPlus()) + "\nrootTwo :: " + String.format("%.2f",getMinus()) + "\n ";
			
	}
}
