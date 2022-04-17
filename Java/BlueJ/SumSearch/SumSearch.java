
import java.util.*;
import java.lang.Math;
public class SumSearch
{
    public static void main(String[] args){
        int[] array = new int[100];
        for(int i = 0; i < 100; i++)
            array[i] = (int)(30 * Math.random());
        insertionSort(array);
        for(int i = 0; i < 100; i++)
             System.out.print(array[i] +" ,");
        System.out.println();
        int target = 46;
        System.out.println("Is the sum " + target + " possible in the array? " + sumSearch(target, array));
    }
    
    public static boolean sumSearch(int targetSum, int[] A){
        int end = A.length - 1;
        boolean sumFound = false;
        if(A[0] + A[1] > targetSum)
            return false;
        if(A[end] + A[end - 1] < targetSum)
            return false;
        while(A[end] + A[end - 1] > targetSum)
            end--;
        while(end -1 > 0){
            if(!sumFound){
                sumFound = binSearchSum(targetSum - end, A, 0, end);
                end--;
            }
            else
                break;
        }
        return sumFound;
    }
    public static boolean binSearchSum(int difference, int[] A, int st, int e){
        int mid = (e + st) / 2;
        if(e >= st){
            if(A[mid] == difference)
                return true;
            else if(A[mid] > difference)
                return binSearchSum(difference, A, st, mid -1);
            else 
                return binSearchSum(difference, A, mid + 1, e);
        }
    return false;
    }
    
    public static void insertionSort(int[] array)
    {
        double count = 0;
        int i, j, key;
        
        for(i = 1; i < array.length; i++)
        {
            key = array[i];
            j = i - 1;
            count++;
            while(j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        System.out.println("The number of kilosteps: " + count / 1000);
    }
}
