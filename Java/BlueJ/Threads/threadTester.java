/*
Name: Denny, John
Email: jdenny3@lsu.edu
Project: PA-1 (Multithreading)
Instructor: Feng Chen
Class: cs4103-sp21
Login ID: cs410326
 */
import java.util.Scanner;

public class threadTester
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row1 = -1, col1 = -1, row2 = -1, col2 =-1;
        while(row1 < 0 && col1 < 0 && row2 < 0 && col2 < 0){
            System.out.print("Enter the size of the first matrix.\nRow::");
            row1 = input.nextInt();
            System.out.print("Col::");
            col1 = input.nextInt();
            row2 = col1;
            System.out.print("Enter the size of the second matrix column.\n");
            System.out.print("Col::");
            col2 = input.nextInt();
        }
        
        int[][] matrix1 = new int[row1][col1];
        int[][] matrix2 = new int[row2][col2];
        int[][] product = new int[row1][col2];
        
        for(int row = 0; row < row1; row++){
            for(int col = 0; col < col1; col++){
                System.out.printf("Enter the value of matrix1[%d][%d]::", row+1, col+1);
                matrix1[row][col] = input.nextInt();
            }
        }
        
        for(int row = 0; row < row2; row++){
            for(int col = 0; col < col2; col++){
                System.out.printf("Enter the value of matrix2[%d][%d]::", row+1, col+1);
                matrix2[row][col] = input.nextInt();
            }
        }
        

        for(int row = 0; row < row1; row++){
            for(int col = 0; col < col2; col++){
                Thread a = new Thread(new matrixThread(row, col, matrix1[row], matrix2, product));
                a.start();
                try{
                    a.join();
                }
                catch(Exception e){}
            }
        }
        
        String p = matrixString(product);
        System.out.printf("You matrix product.\n%s\n",p);
    }
    
    public static String matrixString(int[][] matrix){
        String output = "";
        for(int row = 0; row < matrix.length; row++){
            output += "[";
            for(int col = 0; col < matrix[row].length; col++){
                output += matrix[row][col];
                if(col != matrix[row].length - 1)
                    output += ", ";
            }
            output += "]\n";
        }
        return output;
    }
}
