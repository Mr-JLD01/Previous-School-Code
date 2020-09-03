
import java.util.*;
import java.lang.Math;
public class BinSearchCounter
{
    public static void main(String[] args){
        int[] A = new int[1000];
        for(int i = 0; i < 1000; i++){
            A[i] = (int)(Math.random() * 25);
            
        }
        insertionSort(A);
        String array = "";
        for(int i = 0; i < 1000; i++){
            array += A[i] + ", ";
        }
        System.out.println(array);
        int x = 23;
        System.out.println( x + " appears " + BinSearchCounter(x, A, 0, A.length - 1) + " times");
        x = 16;
        System.out.println( x + " appears " + BinSearchCounter(x, A, 0, A.length - 1) + " times");
        x = 10;
        System.out.println( x + " appears " + BinSearchCounter(x, A, 0, A.length - 1) + " times");
        
    }

    
    public static int BinSearchCounter(int x, int[] A, int st, int e)
    {
        int index = BinSearch(x, A, st, e);
        if(index > -1)
            return 1 + ArrayCount(-1, A, index, 0) + ArrayCount(1, A, index, 0);
        return 0;
    }
    
    
    public static int BinSearch(int x, int[] A, int st, int e){
        if(st <= e){
        int mid = (e + st) / 2;
            if(A[mid] == x){
            return mid;
            }
            else if(A[mid] > x){
            return BinSearch(x,A,st,mid - 1);
            }
            else{
                return BinSearch(x,A,mid + 1, e);
            }
        }
        return -1;
    }

    
    public static int ArrayCount(int stepper, int[] A, int index, int count)
    {
        if(A[index + stepper] == A[index]){
            return ArrayCount(stepper,A,index + stepper,++count);
        }
        else{
            return count;
        }
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
