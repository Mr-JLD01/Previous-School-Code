/* CelsiusGUI
 *John Luke Denny
 */
 
 import javax.swing.JOptionPane;
 
public class CelsiusGUI {
	public static void main (String[] args){
		String inputStr = 
			JOptionPane.showInputDialog
			("Enter the temperature in degrees Celsius: ", "0");
		if(inputStr == null)
			return;
		double celsius = Double.parseDouble(inputStr);
		double fahrenheit = 9.0 / 5.0 * celsius + 32.0;
		JOptionPane.showMessageDialog(null, "The temperature in degrees Fahrenheit is " + fahrenheit);
	}
}
