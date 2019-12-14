/* Code to compare the first letter of two Strings
 * John Luke Denny
 */
 
public class StringFirstLetterCheck{
	private String first, second;
	
	public StringFirstLetterCheck(){
		this(" ", " ");
	}
	
	public StringFirstLetterCheck(String one, String two){
		first = one;
		second = two;
	}
	
	public void setStrings(String one, String two){
		first = one;
		second = two;
	}
	
	public String getFirst(){
		return first;
	}
	
	public String getSecond(){
		return second;
	}
	
	public boolean isFirst(){
		if (first.charAt(0) == second.charAt(0)){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isNotFirst(){
		if(first.charAt(0) != second.charAt(0)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		if (isFirst()){
			return first + " has the same first letter as " + second + "\n";
		}
		if (isNotFirst()){
			return first + " does not have the same first letter as " + second + "\n";
		}
		return " ";
	}
	
}
