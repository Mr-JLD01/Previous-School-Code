import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MagicSquareTester
{
    public static void main(String[] args) throws IOException{
        String fileName = "Luna";
        squareTester(fileName);
        
        fileName = "Mercury";
        squareTester(fileName);
    }
    
    public static void squareTester(String name) throws IOException{
        MagicSquare magic;
        
        FileReader fr = new FileReader(name + ".txt"); 
        BufferedReader file = new BufferedReader(fr);
        file.mark(1024);
        
        String line = "";
        int rowCounter= 0, numCol = 0;
        
        //This is to initially get the dimensions for the matrix that will be the magic square
        while((line = file.readLine()) != null){
            rowCounter++;
            numCol = line.split("\t").length;
        }
        
        //read the file again and create the matrix
        file.reset();
        assert rowCounter == numCol : "This is not a square!";        
        int[][] sq = new int[rowCounter][numCol];
        int row = 0;
        while((line = file.readLine()) != null){
            String[] intLine = line.split("\t");
            for(int col = 0; col < intLine.length; col++){
                sq[row][col] = Integer.parseInt(intLine[col]);
            }
            row++;
        }
        
        magic = new MagicSquare(sq);
        //test to see if all functions are working
        System.out.println(name + "'s row sums are equal :: " + magic.areRowSumsEqual() + ". The value is " + magic.getRowSum());
        System.out.println(name + "'s col sums are equal :: " + magic.areColumnSumsEqual() + ". The value is " + magic.getColSum());
        System.out.println(name + "'s diagonal sums are equal :: " + magic.areDiagonalSumsEqual() + ". The value is " + magic.getDiagonalSum());
        System.out.println(name + " is a magic square :: " + magic.isMagicSquare());
    }
}

