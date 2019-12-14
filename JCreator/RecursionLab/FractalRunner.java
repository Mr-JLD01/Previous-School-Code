/* Recursion Lab - Sierpinski's Gasket and Carpet
 * Graphics runner for lab
 * John Luke Denny
 */
 
import javax.swing.JFrame;

public class FractalRunner extends JFrame{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public FractalRunner(){
		super("Fractal Runner");

		setSize(WIDTH + 40, HEIGHT + 40);

		//getContentPane().add(new Gasket());
		//getContentPane().add(new Carpet());
		getContentPane().add(new Bonus1());
		//getContentPane().add(new Bonus2());

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		FractalRunner run = new FractalRunner();
	}
}