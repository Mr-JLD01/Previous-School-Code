/* Runs the RomanNumeral class
 * John Luke Denny
 */
 
public class RomanNumeralRunner {
	
	public static void main(String[] args){
		System.out.println("John Luke Denny");
		RomanNumeral test = new RomanNumeral(10);
		
		int[] tester = {10, 100, 1000, 2500, 1500, 23, 38, 49};
		for(int num : tester){
			test.setNum(num);
			System.out.println(num + " is " + test.getRoman() + "\n");
		}
		String[] testing = {"LXXVII", "XLIX", "XX", "XXXVIII"};
		for(String rom : testing){
			test.setRoman(rom);
			System.out.println(rom + " is " + test.getNumber(rom) + "\n");
		}
	}
}
