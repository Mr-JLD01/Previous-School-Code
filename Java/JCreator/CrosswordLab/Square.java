/* Crossword Lab
 * Square class
 * Constructs one square of a crossword puzzle grid
 * John Luke Denny
 */

import java.awt.*;

public class Square {
	
	private boolean black;
	private int label;
	
	public Square() {
		this(false, 0);
	}
	
	public Square(boolean isBlack, int num) {
		black = isBlack;
		label = num;		
	}
	
	public boolean isBlack() {
		return black;
	}
	
	public int getLabelNum(){
		return label;
	}
	
	public Color getColor() {
		Color ofSquare = Color.WHITE;
		
		if(black)
			ofSquare = Color.BLACK;
		
		return ofSquare;	
	}
	
	public String toString(){
		return "" + isBlack() + "\n" + getLabelNum() + "\n" + getColor();	
	}	
}
