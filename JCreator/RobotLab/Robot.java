/*Robot
 *John Luke Denny
 */
 
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
 
 public class Robot extends Canvas{
 	public Robot(){
 		setBackground(Color.BLUE);
 	}
 	public void paint(Graphics window){
 		window.setColor(Color.GREEN);
 		window.drawString("Robot Lab By John Luke Denny", 35, 35);
 		
 		//methods to draw robot
 		drawHead(window);
 		drawUpperBody(window);
 		drawLowerBody(window);
 		
 	}
 	
 	public void drawHead(Graphics window){
 		window.setColor(Color.YELLOW);
 		window.fillOval(350,70,100,150);
 		
 		window.setColor(Color.GREEN);
 		window.fillOval(360,125,25,25);
 		
 		window.setColor(Color.GREEN);
 		window.fillOval(415,125,25,25);	
 			
 		window.setColor(new Color(165,42,42));
 		window.fillOval(385,145,30,15);
 		
 		window.setColor(Color.BLACK);
		window.drawArc(375,140,50,40,0,-180);
 	}
 	
 	public void drawUpperBody(Graphics window){
 		window.setColor(Color.RED);
		window.fillRect(360,240,80,120);
		
		window.setColor(Color.WHITE);
		window.drawLine(360,240,270,180);

		window.setColor(Color.WHITE);
		window.drawLine(440,240,540,180);
 	}
 	
 	public void drawLowerBody(Graphics window){
 		window.setColor(Color.GREEN);
		window.fillRect(340,380,120,80);
		
		window.setColor(Color.WHITE);
		window.drawLine(340,460,320,520);

		window.setColor(Color.WHITE);
		window.drawLine(460,460,480,520);
 	}
}
