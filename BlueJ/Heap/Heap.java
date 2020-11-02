import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Heap{
    
    public static void main(String[] args)throws FileNotFoundException, NumberFormatException{
        File inFile = new File("inputFile.txt");
        Scanner in = new Scanner(inFile);
        
        int instructionNum = in.nextInt();
        MinHeap heap = new MinHeap(instructionNum); //takes worst case scenario that all are inserts except last extract min
        for(int i = 1; i < instructionNum; i++){ //assumes final instruction is extract min
            String command = in.next();
            if(command.toUpperCase().equals("IN"))
                heap.insert(in.nextInt());
            else if(command.toUpperCase().equals("DK"))
                heap.decreaseKey(in.nextInt(), in.nextInt());
            else if(command.toUpperCase().equals("EM"))
                heap.extractMin();  
            
        }
        System.out.println(heap.extractMin());
    }
}

class MinHeap{
    //assumes heapSize is always less than arraySize by at least 1
    private int[] array;
    private int arraySize;
    private int heapSize;
    
    public MinHeap(int aSize){
        array = new int[aSize];
        arraySize = aSize;
        heapSize = 0;
    }
    
    public int getHeapSize(){
        return heapSize;
    }
    
    public void setHeapSize(int modifier){
        heapSize += modifier;
    }
    
    public void heapify(int[] arr, int hSize){
        if(hSize > 1){
            int c = hSize - 1; //final child node
            int sub;
            while(c > 0){
                if(arr[c] < arr[(c - 1)/3]){
                    sub = arr[c];
                    arr[c] = arr[(c - 1)/3];
                    arr[(c - 1)/3] = sub;
                }
                c--;
            }
        }
        
    }
    
    public void insert(int element){
        array[getHeapSize()] = element;
        setHeapSize(1);
        heapify(array, getHeapSize());
    }
    
    public void decreaseKey(int index, int newElement){
        if(index < getHeapSize()){
            array[index] = newElement;
            heapify(array, getHeapSize());
        }
        else
            System.out.println("The index given is not in the current heap!");
    }
    
    public int extractMin(){
        int min = array[0];
        for(int i = 1; i <= heapSize; i++){
            array[i - 1] = array[i];
        }
        setHeapSize(-1);
        heapify(array, getHeapSize());
        return min;
    }

}