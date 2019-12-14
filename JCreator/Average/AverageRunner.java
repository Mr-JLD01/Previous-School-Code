/* run average
 *John Luke Denny
 */
 
 
 
public class AverageRunner {
	public static void main(String[] args){
		Average input = new Average();
		System.out.println("By John Luke Denny");
		
		input.setNums(5, 5);
		input.print();
		
		input.setNums(90, 100.0);
		input.print();
		
		input.setNums(100, 85.8);
		input.print();
		
		input.setNums(-100, 55);
		input.print();
		
		input.setNums(15236, 5642);
		input.print();
		
		input.setNums(1000, 555);
		input.print();
		
	}
}
