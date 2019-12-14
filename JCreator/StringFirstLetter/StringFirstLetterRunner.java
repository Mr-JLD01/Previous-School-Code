/* Runs StringFirstLetterCheck
 * John Luke Denny
 */

public class StringFirstLetterRunner{
	
	public static void main(String[] args){
		
		StringFirstLetterCheck test = new StringFirstLetterCheck();
		
		System.out.println("John Luke Denny");
		
		test.setStrings("hello", "howdy");
		System.out.println(test.toString());
		
		test.setStrings("one", "two");
		System.out.println(test.toString());
		
		test.setStrings("three", "two");
		System.out.println(test.toString());
		
		test.setStrings("THE", "SECTION");
		System.out.println(test.toString());
		
		test.setStrings("State", "Champions");
		System.out.println(test.toString());
		
		test.setStrings("CENTENNIAL", "COUGARS");
		System.out.println(test.toString());
		
		 
	}
}
