/* BlackJack Lab 
 * CardTestTwo
 * John Luke Denny
 */ 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import BlackJack.Card;
import BlackJack.BlackJackCard;

public class CardTestTwo extends JPanel{
	
	public CardTestTwo(){
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void paintComponent(Graphics window){
		super.paintComponent(window);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));

		window.drawString("BLACKJACK CARD TEST",90,40);

		Card one = new BlackJackCard(10,"HEARTS",90,120);
		one.drawCard(window,100,100);

		Card two = new BlackJackCard(3,"CLUBS",90,120);
		two.drawCard(window,200,100);

		Card three = new BlackJackCard(9,"SPADES",90,120);
		three.drawCard(window,300,100);

		//instantiate more cards
		Card four = new BlackJackCard(1,"DIAMONDS",90,120);
		four.drawCard(window,400,100);

		Card five = new BlackJackCard(8,"SPADES",90,120);
		five.drawCard(window,500,100);

		Card six = new BlackJackCard(13,"HEARTS",90,120);
		six.drawCard(window,100,230);
		
		Card seven = new BlackJackCard(1,"SPADES",90,120);
		seven.drawCard(window,200,230);

		Card eight = new BlackJackCard(5,"SPADES",90,120);
		eight.drawCard(window,300,230);

		Card nine = new BlackJackCard(12,"HEARTS",90,120);
		nine.drawCard(window,400,230);
		
		Card ten = new BlackJackCard(11,"HEARTS",90,120);
		ten.drawCard(window,500,230);
		
	}
}