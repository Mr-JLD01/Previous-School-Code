/* BlackJack Lab
 * DeckTestTwo
 */ 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import BlackJack.Card;
import BlackJack.Deck;

public class DeckTestTwo extends JPanel{
	
	public DeckTestTwo(){
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void paintComponent(Graphics window){
		super.paintComponent(window);
		
		Deck deck = new Deck();

		for(int i = 0; i < deck.size(); i++){
		   	Card c = deck.nextCard();
		   	c.setWidth(90);
		   	c.setHeight(120);
		   	c.drawCard(window, i * 11 + 25, 50 + i * 4);
		}

		deck.shuffle();

		for(int i = 0; i < deck.size(); i++){
		   	Card c = deck.nextCard();
		   	c.setWidth(90);
		   	c.setHeight(120);
		   	c.drawCard(window, i * 11 + 25, 250 + i * 4);
		}
	}
}