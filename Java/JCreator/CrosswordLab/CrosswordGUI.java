/* Crossword Lab
 * Displays crossword puzzle
 */
 
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CrosswordGUI {
	
	public static void main(String[] args) {
		
		boolean[][] black = new boolean[7][9];
		
		int[] blackX = {0,0,0,0,1,2,2,2,3,3,4,4,4,5,6,6,6,6};
		int[] blackY = {0,3,4,5,4,6,7,8,2,6,0,1,2,4,3,4,5,8};
				
		for(int k = 0; k < blackX.length; k++)
			black[blackX[k]][blackY[k]] = true;
			
		Crossword c = new Crossword(black);
		
		final int WIDTH = 9;
		final int HEIGHT = 7;
		
		JFrame frame = new JFrame();
		frame.setTitle("John Luke Denny");
		frame.setSize(WIDTH * 50, HEIGHT * 50);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(HEIGHT, WIDTH, 2, 2));
		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for(int k = 0; k < WIDTH * HEIGHT; k++){
			pane.add(c.getPanels().get(k));
		}
		frame.setVisible(true);		
	}	
}
