
public class MagicSquare
{
    private int[][] square;
    private int[] rowSum, colSum, diagonalSum = new int[2];
    private boolean areRow, areCol, areDiagonal;
    
    public MagicSquare(int[][] sq){
        square = sq;
        areRow = areRowSumsEqual();
        areCol = areColumnSumsEqual();
        areDiagonal = areDiagonalSumsEqual();
    }

    //returns row sum if all rows have same sum
    public String getRowSum(){
        if(areRow){
            return "" + rowSum[0];
        }
        return "There are different row sums.";
    }
    
    //returns col sum if all columns have same sum
    public String getColSum(){
        if(areCol){
            return "" + colSum[0];
        }
        return "There are different column sums.";
    }
    
    //returns diagonal sum if both diagonals have same sum
    public String getDiagonalSum(){
        if(areDiagonal){
            return "" + diagonalSum[0];
        }
        return "There are different diagonal sums.";
    }
    
    //sees if row sums are equal
    public boolean areRowSumsEqual(){
      int[] rowSums = new int[square[0].length];
      
      //generates the row sum array
      for(int row = 0; row < square.length; row++){
          for(int col = 0; col < square[row].length; col++){
              rowSums[row] += square[row][col];
          }
      }
      rowSum = rowSums;
      int compare = rowSums[0];
      //compares first element to the rest
      for(int i = 1; i < rowSums.length; i++){
          if(compare != rowSums[i])
              return false;
      }
      return true;  
    }
    
    public boolean areColumnSumsEqual(){
      int[] colSums = new int[square.length];
      
      //generates column sum array
      for(int row = 0; row < square.length; row++){
          for(int col = 0; col < square[row].length; col++){
              colSums[col] += square[row][col];
          }
      }
      colSum = colSums;
      int compare = colSums[0];
      
      //compares first element to the rest
      for(int i = 1; i < colSums.length; i++){
          if(compare != colSums[i])
              return false;
      }
      return true;  
    }
    
    public boolean areDiagonalSumsEqual(){
      int diagonal1 = 0, diagonal2 = 0;
      for(int row = 0; row < square.length; row++){
          diagonal1 += square[row][row];
      }
      diagonalSum[0] = diagonal1;
      for(int row = 0; row < square.length; row++){
          diagonal2 += square[row][square.length-row-1];
      }
      diagonalSum[1] = diagonal2;
      return diagonal1 == diagonal2;  
    }
    
    public boolean isMagicSquare(){
        return areRow && areCol && areDiagonal && (rowSum[0] == colSum[0] && colSum[0] == diagonalSum[0]);
    }
}
