/* Run class Number
 *John Luke Denny
 */
public class NumberRunner {
	
	public static void main(String[] args){
		
		Number any = new Number(); 
			
		System.out.println("John Luke Denny");
		any.setNum(15472);
		
		System.out.println("The sum of the digits of " + any.getNum() + " is " + any.sumDigits());
		
		any.setNum(10101);
		System.out.println(any.getNum() + " in base 10 is " + any.twoToTen());
		
		any.setNum(134143162);
		int base = 16;
		System.out.println(any.getNum() + " in base " + base + " is " + any.tenToAny(base));
		
		any.setNum(19);
		System.out.println(any.getNum() + " is " + ((any.isPrime())?"" : "not ") + "prime");
		
		any.setNum(26);
		System.out.println(any.getNum() + " is " + ((any.isPrime())?"" : "not ") + "prime");
		
		any.setNum(70807);
		System.out.println(any.getNum() + " is " + ((any.isPalindrome())?"" : "not ") + "a palindrome");
		
		any.setNum(70801);
		System.out.println(any.getNum() + " is " + ((any.isPalindrome())?"" : "not ") + "a palindrome");
		
		any.setNum(6);
		System.out.println(any.getNum() + " is " + ((any.isPerfect())?"" : "not ") + "perfect");
		
		any.setNum(10);
		System.out.println(any.getNum() + " is " + ((any.isPerfect())?"" : "not ") + "perfect");
		
		any.setNum(20);
	 	Number m = new Number(25);
		System.out.println("The GFC of " + any.getNum() + " and " + m.getNum() + " is " + any.gfc(m));

	 	any.setNum(220); 
	 	m.setNum(284);
		System.out.println(any.getNum() + " is " + ((any.isAmicableWith(m))?"" : "not ") + "amicable with " + m.getNum());
		
		any.setNum(10);
		m.setNum(50);
		System.out.println(any.getNum() + " is " + ((any.isAmicableWith(m))?"" : "not ") + "amicable with " + m.getNum());
	
		any.setNum(716);
		System.out.println(any.getNum() + " is " + ((any.isHappy())?"happy" : "sad"));
		
		any.setNum(79750);
		System.out.println(any.getNum() + " is " + ((any.isHappy())?"happy" : "sad"));
		
		any.setNum(487);
		System.out.println(any.getNum() + " is a " + ((any.isHappy())?"happy " : "sad ") + ((any.isPrime())?"prime" : "number"));
		
		
	}
}
