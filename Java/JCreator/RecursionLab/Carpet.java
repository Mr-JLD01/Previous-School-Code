/* Recursion Lab - Sierpinski's Carpet
 * John Luke Denny
 */
 
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

public class Carpet extends Canvas implements Runnable{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Carpet(){
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window ){
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL",Font.BOLD,18));
		window.drawString("Sierpinski's Carpet: John Luke Denny", 25, 50);

		carpet(window, 60, 60, HEIGHT - 90);
	}

	public void carpet(Graphics window, int x, int y, int size){
		//base case goes here
		if(size > 5){
		
			//make a random color here later after you finish
			
			//set main color for now
			window.setColor(new Color((int)(255 * Math.random()), (int)(255 * Math.random()), (int)(255 * Math.random())));
			
			//draw main triangle using fillPolygon
			window.fillRect(x, y, size, size);
			//calculate midpoints of each side
			int newSize = (int)(size / 3.0);
			
			int midX1 = x + newSize;
			int midX2 = x + (newSize * 2);
				
			int midY1 = y + newSize;
			int midY2 = y + (newSize * 2);
			
			
			//set color to background color
			window.setColor(Color.WHITE);
			//"cut out" center triangle using fillPolygon
			window.fillRect(midX1, midY1, newSize, newSize);
			
			//make recursive calls on the eight outer squares
			carpet(window, x, y, newSize);
			carpet(window, midX1, y, newSize);
			carpet(window, midX2, y, newSize);
			
			carpet(window, x, midY1, newSize);
			carpet(window, midX2, midY1, newSize);
			
			carpet(window, x, midY2, newSize);
			carpet(window, midX1, midY2, newSize);
			carpet(window, midX2, midY2, newSize);
			
			run();
		}
	}

	public void run(){
		try{
		  	Thread.currentThread().sleep(3);
		}
		catch(Exception e){
		}
	}
}
