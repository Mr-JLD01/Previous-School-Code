/* BlackJack Lab 
 * Card
 * John Luke Denny
 */

package BlackJack;

import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;



public abstract class Card{
	
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;
	private int width;
	private int height;
	private Image image;
	private boolean hidden;

  	public Card(){
		this(0,"",0,0);
   	}

  	public Card(int f, String s){
  	   	this(f,s,0,0);
  	}

 	public Card(int f, String s, int wid, int ht){
  	   	//set instance variables to parameter values
  	   	//intialize all instance variables
  	   	face = f;
  	   	suit = s;
  	   	width = wid;
  	   	height = ht;
  	   	setImage();
  	   	
  	}
	public void setImage(){
		String name = "";
		if(hidden)
			name = "BACK";
  	   	else 
  	   		name = this.toString().replaceAll(" ","");
		try{
			URL url = getClass().getResource("/images/" + name + ".jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e){
			//feel free to do something here
		}
	}
	// mutators
  	public void setFace(int f){
  	   	face = f;
  	}

  	//add more set methods
	public void setSuit(String s){
  	   	suit = s;
  	}
  	
  	public void setWidth(int wid){
  	   	width = wid;
  	}
  	
  	public void setHeight(int ht){
  	   	height = ht;
  	}
  	public void setHidden(){
  		hidden = true;
  		setImage();
  	}
  	
  	public void setUnHidden(){
  		hidden = false;
  		setImage();
  	}

  	//accessors
  	public int getFace(){
  	    return face;
  	}

  	//add more get methods
	public String getSuit(){
  	    return suit;
  	}

	public int getWidth(){
  	    return width;
  	}

	public int getHeight(){
  	    return height;
  	}


	public boolean equals(Object obj){
		//add in code to complete the equals method
		Card other = (Card)obj;
		return face == other.getFace() && suit.equals(other.getSuit());
	}

  	public abstract int getValue();

  	public String toString(){
  		//get rid of the "" has a value of " + getValue()" before you start 
  		//the graphics part with the images (look at the image names)
  		return FACES[face] + "of" + getSuit();// + " has  a value of " + getValue();
  	}

	public void drawCard(Graphics window, int x, int y){
		window.drawImage(image,x,y,width,height,null);
	}
}