/* Germany
 *John Luke Denny
 */
 
 import javax.swing.*;
import java.awt.*;
 
public class Germany {
	public static void main(String[] args){
		JFrame theGUI = new JFrame();
		theGUI.setTitle("The flag of Germany");
		theGUI.setSize(300, 200);
		theGUI.setResizable(false);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 0, 0));
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(208, 0, 0));
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 206, 0));
		Container pane = theGUI.getContentPane();
		pane.setLayout(new GridLayout(3,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		theGUI.setVisible(true);
	}
}
