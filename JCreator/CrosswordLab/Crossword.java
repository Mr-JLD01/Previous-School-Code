/* Crossword Lab
 * Crossword Class
 * Each element is a Square object with a color (black or white) and a number label.
 * There is at least one row in the puzzle.
 * John Luke Denny
 */
 
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Crossword {
	
	private Square[][] puzzle;
	
	public Crossword(boolean[][] blackSquares){
		
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
		
		//Constructs the crossword puzzle grid.
		//blackSquares contains the layout of the puzzle.
		int label = 1;
		for(int row = 0; row < blackSquares.length; row++){
			for(int col = 0; col < blackSquares[row].length; col++){
				if(toBeLabeled(row, col, blackSquares))
					puzzle[row][col] = new Square(blackSquares[row][col], label++);
				
				else
					puzzle[row][col] = new Square(blackSquares[row][col], 0);	
			}
		}
					
	}
	
	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares){
		//Returns true if the Square at row r and column c should be labeled; false otherwise.	
		if(blackSquares[r][c])
			return false;
		else if(r == 0 || c == 0 || blackSquares[r - 1][c] || blackSquares[r][c - 1])
			return true;
		else
			return false;
	}
	
	public ArrayList<JPanel> getPanels(){
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		for(Square[] r : puzzle){
			for(Square s : r){
				JPanel p = new JPanel();	
				p.setBackground(s.getColor());
				p.setLayout(new GridLayout(3,3));
				if(s.getLabelNum() != 0){
					JLabel lab = new JLabel(Integer.toString(s.getLabelNum()));
					p.add(lab);
				}	
				panels.add(p);		
			}
		}
		return panels;	
	}
	
	public String toString(){
		String output = "";
		for(int r = 0; r < puzzle.length; r++){
			for(int c = 0; c < puzzle[r].length; c++){
				output += "(" + r + "," + c + ") " + puzzle[r][c] + "\n";	
			}
		}
		return output;	
	}	
}
