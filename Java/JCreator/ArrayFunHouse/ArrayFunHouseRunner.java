/* Code to run ArrayFunHouse
 * John Luke Denny
 */
 
 import java.util.Arrays;
 
public class ArrayFunHouseRunner {
	public static void main(String[] args){
		System.out.println("John Luke Denny");
		int[] test1 = {7, 4, 10, 0, 1, 7, 6, 5, 3, 2, 9, 7};
		
		System.out.println(Arrays.toString(test1));
		System.out.println("sum of spots 3-6 = " + ArrayFunHouse.sumSection(test1,3,6));
		System.out.println("sum of spots 2-9 = " + ArrayFunHouse.sumSection(test1,2,9));
		System.out.println("# of 4s = " + ArrayFunHouse.numCount(test1,4));
		System.out.println("# of 9s = " + ArrayFunHouse.numCount(test1,9));
		System.out.println("# of 7s = " + ArrayFunHouse.numCount(test1,7));
		System.out.println("new array with all 7s removed = " + Arrays.toString(ArrayFunHouse.numRemover(test1,7)));
		System.out.println("# of 7s = " + ArrayFunHouse.numCount(ArrayFunHouse.numRemover(test1,7),7) + "\n\n");
		
		int[] test2 = {7, 4, 2, 7, 3, 4, 6, 7, 8, 9, 7, 0, 10, 7, 0, 1, 7, 6, 5, 7, 3, 2 ,7, 9, 9, 8, 7};
		
		System.out.println(Arrays.toString(test2));
		System.out.println("sum of spots 3-16 = " + ArrayFunHouse.sumSection(test2,3,16));
		System.out.println("sum of spots 2-9 = " + ArrayFunHouse.sumSection(test2,2,9));
		System.out.println("# of 0s = " + ArrayFunHouse.numCount(test2,0));
		System.out.println("# of 3s = " + ArrayFunHouse.numCount(test2,3));
		System.out.println("# of 7s = " + ArrayFunHouse.numCount(test2,7));
		System.out.println("new array with all 7s removed = " + Arrays.toString(ArrayFunHouse.numRemover(test2,7)));
		System.out.println("# of 7s = " + ArrayFunHouse.numCount(ArrayFunHouse.numRemover(test2,7),7));
	}
}
