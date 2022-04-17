/* runs the morse code class
 *John Luke Denny
 */
public class MorseCodeRunner {
	
	public static void main(String[] args){
		
		System.out.println("John Luke Denny");
		MorseCode encrypt = new MorseCode();
		
		encrypt.setLetter('A');
		System.out.println(encrypt);
		
		encrypt.setLetter('B');
		System.out.println(encrypt);
		
		encrypt.setLetter('3');
		System.out.println(encrypt);
		
		encrypt.setLetter('Z');
		System.out.println(encrypt);
		
		encrypt.setLetter('8');
		System.out.println(encrypt);
		
		encrypt.setLetter('F');
		System.out.println(encrypt);
		
		encrypt.setLetter('0');
		System.out.println(encrypt);
		
	}
}
