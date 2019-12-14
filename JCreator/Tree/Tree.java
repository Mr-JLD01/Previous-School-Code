/* Tree Lab
 * Your Name
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Font;
import java.awt.Canvas;

public class Tree extends Canvas{
	
	public Tree(){
		setBackground(Color.WHITE);
	}

	public void paint(Graphics window){
		window.setColor(Color.RED);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.drawString("Happy Holidays! From: John Luke Denny ", 50, 50);
		tree(window);
		star(window);
		ornaments(window);
		presents(window);
	}
	
	public void tree(Graphics window){
		int[] treeXPoints = {400,200,600};
		int[] treeYPoints = {100,500,500};
		Polygon tree = new Polygon(treeXPoints,treeYPoints,treeXPoints.length);
		window.setColor(Color.GREEN);
		window.fillPolygon(tree);
		
		window.setColor(new Color(175,66,31));		
		window.fillRect(380,500,40,50);
	}

	public void star(Graphics window){
		int[] starXPoints = {400,437,425,450,417,400,382,350,375,362};
		int[] starYPoints = {100,125,90,65,65,25,65,65,90,125};
		Polygon star = new Polygon(starXPoints,starYPoints,starXPoints.length);
		window.setColor(Color.YELLOW);
		window.fillPolygon(star);
	}
	
	public void ornaments(Graphics window){
		window.setColor(Color.BLUE);
		window.fillOval(400,200,25,25);
		window.setColor(Color.BLUE);
		window.fillOval(300,400,25,25);
		window.setColor(Color.YELLOW);
		window.fillOval(347,322,25,25);
		window.setColor(Color.WHITE);
		window.fillOval(547,476,25,25);
		window.setColor(Color.BLACK);
		window.fillOval(515,465,25,25);
		window.setColor(Color.RED);
		window.fillOval(334,256,25,25);
		window.setColor(Color.RED);
		window.fillOval(333,476,25,25);
		window.setColor(Color.ORANGE);
		window.fillOval(444,399,25,25);
		window.setColor(Color.CYAN);
		window.fillOval(375,289,25,25);
	}
	
	public void presents(Graphics window){
		window.setColor(Color.MAGENTA);
		window.fillRect(125,475,75,100);
		
		int[] bow1XPoints = {163,173,173,153,153};
		int[] box1YPoints = {475,465,485,465,485};
		Polygon bow1 = new Polygon(bow1XPoints,box1YPoints,bow1XPoints.length);
		window.setColor(Color.ORANGE);
		window.fillPolygon(bow1);
		
		window.setColor(new Color(175,66,31));		
		window.fillRect(380,500,40,50);
		
		
		
		window.setColor(Color.RED);
		window.fillRect(750,475,75,100);
		
		int[] bow2XPoints = {788,798,798,778,778};
		int[] box2YPoints = {475,465,485,465,485};
		Polygon bow2 = new Polygon(bow2XPoints,box2YPoints,bow2XPoints.length);
		window.setColor(Color.YELLOW);
		window.fillPolygon(bow2);
		
		window.setColor(Color.CYAN);
		window.fillRect(25,525,50,50);
		
		int[] bow3XPoints = {50,60,60,40,40};
		int[] box3YPoints = {525,515,535,515,535};
		Polygon bow3 = new Polygon(bow3XPoints,box3YPoints,bow3XPoints.length);
		window.setColor(Color.BLACK);
		window.fillPolygon(bow3);
		
		window.setColor(Color.BLACK);
		window.fillRect(625,525,100,50);
		
		int[] bow4XPoints = {675,695,695,655,655};
		int[] box4YPoints = {525,515,535,515,535};
		Polygon bow4 = new Polygon(bow4XPoints,box4YPoints,bow4XPoints.length);
		window.setColor(Color.RED);
		window.fillPolygon(bow4);
		
	}

}