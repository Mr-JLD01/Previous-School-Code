/* Sums up array sections, count number of certain integers in an array
 * and removes certain values of the array
 * John Luke Denny
 */
 
 import java.util.Arrays;
 
public class ArrayFunHouse {
	
	private static int[] array;
	
	public static int sumSection(int[] a , int start, int end){
		int[] array = a;
		int st = start;
		int en = end;
		int sum = 0;
		
		for(int i = st; i <= en; i++){
			sum += array[i];	
		}
		return sum;	
	}
	
	public static int numCount(int[] a ,int num){
		int[] array = a;
		int quant = num;
		int count = 0;
		for(int j = 0; j < array.length; j++){
			if(array[j] == quant){
				count++;
			}
		}
		return count;
	}
	
	public static int[] numRemover(int[] a ,int remove){
		int[] array = a;
		int rem = remove;
		int spot = 0;
		int[] removed = new int[array.length - numCount(array, rem)];
		for(int k = 0; k < array.length; k++){
			if(array[k] != rem){
				removed[spot] = array[k];
				spot++;
			}
		}

		return removed;
	}
	
	public static String toString(int[] a){
		int[] array = a;
		return  Arrays.toString(array);
	}
	
}
