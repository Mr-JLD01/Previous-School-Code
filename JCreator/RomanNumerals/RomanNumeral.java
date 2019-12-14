/* Code to translate @num from arabic numerals into Roman numerals and vice versa
 * John Luke Denny
 */
public class RomanNumeral {
	
	private int num;
	
	private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private static final String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	
	
	public RomanNumeral(){
		this(0);
	}
	
	public RomanNumeral(int n){
		num = n;
	}
	
	public RomanNumeral(String rom){
		num = getNumber(rom);
	}
	
	public void setNum(int n){
		num = n;
	}
	
	public void setRoman(String rom){
		num = getNumber(rom);
	}
	
	public int getNum(){
		return num;
	}
	
	public int getNumber(String rom){
		int out = 0;
		for(int k = 0; k < roman.length; k++){
			while(rom.indexOf(roman[k]) == 0){
				out += numbers[k];
				rom = rom.substring(roman[k].length());
			}
		}
		
		return out;
	}
	
	public String getRoman(){
		String out = "";
		int rem = num;
		for(int k = 0; k < numbers.length; k++){
			while(rem >= numbers[k]){
				out += roman[k];
				rem -= numbers[k];
			}
		}
		return out;
	}
	
	public String toString(){
		return getRoman();
	}
}
