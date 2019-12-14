/* Thailand
 *John Luke Denny
 */
 
import javax.swing.*;
import java.awt.*;
 
public class Thailand {
	public static void main (String[] args){
		JFrame theGUI = new JFrame();
		theGUI.setTitle("The flag of Thailand");
		theGUI.setSize(300, 200);
		theGUI.setResizable(false);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(237, 28, 36));
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(36, 29, 79));
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(36, 29, 79));
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(255, 255, 255));
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(237, 28, 36));
		Container pane = theGUI.getContentPane();
		pane.setLayout(new GridLayout(6,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		pane.add(panel6);
		theGUI.setVisible(true);
	}
}
