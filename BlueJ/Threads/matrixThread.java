
/*
Name: Denny, John
Email: jdenny3@lsu.edu
Project: PA-1 (Multithreading)
Instructor: Feng Chen
Class: cs4103-sp21
Login ID: cs410326
 */
public class matrixThread implements Runnable
{
    // instance variables - replace the example below with your own
    private int row;
    private int column;
    private int product;
    private int[] fullRow;
    private int[][] matrix;
    private int[][] pMatrix;
    
    public matrixThread(int r, int c, int[] fR, int[][] m, int[][] p)
    {
        row = r;
        column = c;
        fullRow = fR;
        matrix = m; 
        pMatrix = p;
    }
    
    public void run(){
        int sum = 0;
        for(int i = 0; i < fullRow.length; i++){
            sum += fullRow[i] * matrix[i][column];
        }
        pMatrix[row][column] = sum;
    }
}
