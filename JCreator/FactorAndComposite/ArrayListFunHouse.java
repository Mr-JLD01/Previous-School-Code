/* Code to find the factors of numbers and return composite numbers to an array list, no prime numbers
 * John Luke Denny
 */
 
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;
 import java.util.Arrays;
 
public class ArrayListFunHouse {
	
	public static ArrayList<Integer> getListOfFactors(int number){
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int k = 2; k < number; k++){
			if(number % k == 0)
				factors.add(k);
		}
		return factors;
		
	}
	
	public static void keepOnlyCompositeNumbers(List<Integer> nums){
		
		for(int i = nums.size() - 1; i > -1; i--){
			if(getListOfFactors(nums.get(i)).size() == 0)
				nums.remove(i);
		}
		
	}
	
	public static void main(String[] args){
		System.out.println("John Luke Denny");
		
		System.out.println(getListOfFactors(9));
		System.out.println(getListOfFactors(23));
		System.out.println(getListOfFactors(50));
		System.out.println(getListOfFactors(100));
		System.out.println(getListOfFactors(762));
		
		Integer[] nums = {2,6,8,10,12,13,15,17,24,55,66,78,77,79};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums));
		keepOnlyCompositeNumbers(list);
		System.out.println("Original List\n" + Arrays.toString(nums) + "\nComposite List\n" + list);
		
	}
	
}
