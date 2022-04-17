/* Recursion Lab - Sierpinski's Gasket
 * John Luke Denny
 */
 
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

public class Gasket extends Canvas implements Runnable{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Gasket(){
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window ){
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL",Font.BOLD,18));
		window.drawString("Sierpinski's Gasket: John Luke Denny", 25, 50);

		gasket(window, (WIDTH - 10) / 2, 20, WIDTH - 40, HEIGHT - 20, 40, HEIGHT - 20);
	}

	public void gasket(Graphics window, int x1, int y1, int x2, int y2, int x3, int y3){
		//base case goes here
		if(x2 - x1 > 5 || y2 - y1 > 5){
		
			//make a random color here later after you finish
			
			//set main color for now
			window.setColor(new Color((int)(255 * Math.random()), (int)(255 * Math.random()), (int)(255 * Math.random())));
			//draw main triangle using fillPolygon
			int[] x = {x1, x2, x3};
			int[] y = {y1, y2, y3};
			window.fillPolygon(x, y, 3);
			//calculate midpoints of each side
			int midX1 = (x1 + x2) / 2;
			int midX2 = (x2 + x3) / 2;
			int midX3 = (x1 + x3) / 2;
				
			int midY1 = (y1 + y2) / 2;
			int midY2 = (y2 + y3) / 2;
			int midY3 = (y1 + y3) / 2;
			//set color to background color
			window.setColor(Color.WHITE);
			//"cut out" center triangle using fillPolygon
			int[] xM = {midX1, midX2, midX3};
			int[] yM = {midY1, midY2, midY3};
			window.fillPolygon(xM, yM, 3);
			//make recursive calls on the three outer triangles
			gasket(window, x1, y1, midX1, midY1, midX3, midY3);
			gasket(window, midX3, midY3, x3, y3, midX2, midY2);
			gasket(window, midX1, midY1, midX2, midY2, x2, y2);
			
			
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