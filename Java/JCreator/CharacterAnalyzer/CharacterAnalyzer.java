/*Analyzes variables as uppercase, lowercase, or a digit
 *John Luke Denny
 */
public class CharacterAnalyzer{
	private char ascii;
	
	public CharacterAnalyzer(){
		this('A');
	}
	
	public CharacterAnalyzer(char letter){
		ascii = letter;
	} 
	
	public void setChar(char letter){
		ascii = letter;	
	}
	
	public char getAscii(){
		return ascii;
	}
	
	public boolean isDigit(){
		if (ascii < 65){
			return true;
		}
		return false;
	}
	
	public boolean isUpperCase(){
		if (ascii >= 65){
			if (ascii < 97)
				return true;
		}
		return false;
	}
	
	public boolean isLowerCase(){
		if (ascii >=97){
			return true;
		}
		return false;
	}
	
	public String toString(){
		if (isDigit()){
			return ascii + " is a digit. ASCII = " + (int)ascii + "\n\n";
		}		
		if (isUpperCase()){
			return ascii + " is an uppercase letter. ASCII = " + (int)ascii + "\n\n";
		}
				
		if (isLowerCase()){
			return ascii + " is a lowercase letter. ASCII = " + (int)ascii + "\n\n";
		}
		return " ";
	}
	
}
