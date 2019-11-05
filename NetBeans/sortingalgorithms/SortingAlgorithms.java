//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Sorting in O(nlogn)
//Submission Time: 5:15 PM

package sortingalgorithms;

import java.util.Scanner;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;


public class SortingAlgorithms {

    
    public static void main(String[] args) {
        System.out.println("Please enter the size of your file:");
        
        Scanner input = new Scanner(System.in);
        int listSize = input.nextInt();
        
        int[] array = new int[listSize];
        Random rand = new Random();
        
        for(int i= 0 ; i<listSize; i++)
            array[i] = rand.nextInt(1000);
        
//        Instant start = Instant.now();
//        bubbleSort(array.clone());
//        Instant finish = Instant.now();
//        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
//        
//        start = Instant.now();
//        csBubbleSort(array.clone());
//        finish = Instant.now();
//        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
        
        Instant start = Instant.now();
        selectionSort(array.clone());
        Instant finish = Instant.now();
        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
        
        start = Instant.now();
        insertionSort(array.clone());
        finish = Instant.now();
        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
        
        start = Instant.now();
        mergeSort(array.clone());
        finish = Instant.now();
        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
        
        start = Instant.now();
        quickSort(array.clone(), 0, array.length - 1);
        finish = Instant.now();
        System.out.println("Time is: "+ Duration.between(start, finish).toMillis());
        
    }
    
    public static void bubbleSort(int[] array)
    {
        double count = 0;
        
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length - i - 1; j++)
            {
                count++;
                if(array[j] > array[j + 1])
                {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("The number of kilosteps: " + count / 1000);
    }
    
    
    public static void csBubbleSort(int[] array)
    {
        double count = 0;
        
        for(int i = 0; i < array.length; i++)
        {
            boolean swap = false;
            for(int j = 0; j < array.length - i - 1; j++)
            {
                count++;
                if(array[j] > array[j + 1])
                {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swap = true;
                }
            }
            if(!swap)
                break;
        }
        System.out.println("The number of kilosteps: " + count / 1000);
    }
    
    
    public static void selectionSort(int[] array)
    {
        double count = 0;
        int minIndex;
        
        for(int i = 0; i < array.length; i++)
        {
            minIndex = i;
            for(int j = i + 1; j < array.length; j++)
            {
                count++;
                if(array[minIndex] > array[j])
                {
                    minIndex = j;
                    
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("The number of kilosteps: " + count / 1000);
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
    
    
    public static void mergeSort(int[] array)
    {
        if(array.length == 1)
            return;
        
        int mid = array.length / 2;
        int[] left = new int[mid]; 
        int[] right = new int[array.length - mid];
        
        for(int i = 0; i < mid; i++)
        {
            left[i] = array [i];
        }
        
        for(int j = mid; j < array.length; j++)
        {
            right[j - mid] = array[j];
        }
        
        mergeSort(left);
        mergeSort(right);
        
        merge(array, left, right, left.length, right.length);
    }
    
    
    public static void merge(int[] array, int[] left, int[] right, int l, int r)
    {
        int i = 0, j = 0, k = 0;
        
        while(i < l && j < r)
        {
            if(left[i] <= right[j])
            {
                array[k] = left[i];
                i++;
            }
            else
            {
                array[k] = right[j];
                j++;
            }
        }
        
        while(i < l)
            array[k++] = left[i++];
        
        while(j < r)
            array[k++] = right[j++];
    }
    
    
    public static void quickSort(int[] arr, int low, int high)
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }
         
        if (low >= high){
            return;
        }
 
        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
 
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j)
        {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot)
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot)
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
            if (i <= j)
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }
     
    public static void swap (int[] array, int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
