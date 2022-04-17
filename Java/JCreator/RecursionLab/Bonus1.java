/* Recursion Lab - bonus1
 * John Luke Denny
 */
 
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

public class Bonus1 extends Canvas implements Runnable{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Bonus1(){
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window ){
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL",Font.BOLD,18));
		window.drawString("Bonus Lab 1: John Luke Denny", 25, 50);

		bonus1(window, 60, 60, 405);
	}

	public void bonus1(Graphics window, int x, int y, int size){
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
			//"cut out" four squares using fillPolygon
			window.fillRect(midX1, y, newSize, newSize);
			window.fillRect(x, midY1, newSize, newSize);
			window.fillRect(midX1, midY2, newSize, newSize);
			window.fillRect(midX2, midY1, newSize, newSize);
			
			//make recursive calls on the five other squares
			bonus1(window, x, y, newSize);
			bonus1(window, midX2, y, newSize);
			bonus1(window, midX1, midY1, newSize);
			bonus1(window, x, midY2, newSize);
			bonus1(window, midX2, midY2, newSize);
			
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
