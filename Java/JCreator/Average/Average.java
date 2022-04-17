/* Set variables for averaging
 *John Luke Denny
 */
public class Average {
	private double one, two, sum, average;
	
	public void setNums(double num1, double num2){
		one = num1;
		two = num2;
	}
	public void sum(){
		sum = one + two;
	}
	
	public void average(){
		sum();
		average = sum / 2;
	}
	
	public void print(){
		average();
		System.out.print(one + " + " + two + " has an average of ");
		System.out.printf("%.2f", average);
		System.out.println("\n");
		
	}
	
}
