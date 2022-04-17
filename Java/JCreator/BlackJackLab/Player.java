/* BlackJack Lab 
 * Player
 * John Luke Denny
 */ 

package BlackJack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import BlackJack.AbstractPlayer;

public class Player extends AbstractPlayer{
   	//constructors 
  	 public Player(){
  	 	super();
 	 }
 	 
 	 public Player(int score){
  	 	super(score);
 	 }
   
   	public boolean hit(){
		
      	return false;
   	}
}