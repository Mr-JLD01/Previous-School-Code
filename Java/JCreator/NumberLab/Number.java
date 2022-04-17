/* Code for While loops
 *John Luke Denny
 */ 
public class Number {
	private int number;
	
	public Number(){
		number = 0;
	} 
	
	public Number(int num){
		number = num;
	}
	
	public void setNum(int num){
		number = num;
	}
	
	public int getNum(){
		return number;	
	}
	
	public int sumDigits(){
		int total = 0;
		
		while(number > 0 ){
			total+= number % 10;
			number /= 10;
		}
		
		return total;
	}
	public long twoToTen(){
		int rem = number;
		int power = 0;
		long result = 0;
		while(rem > 0){
			result += (rem% 10) * Math.pow(2, power);
			rem/= 10;
			power++;
		}
		return result;
	}
	public String tenToAny(int base){
		int rem = number;
		String result = "";
		while(rem > 0){
			switch(rem % base){
			case 10 : result = 'A' + result; break;
			case 11 : result = 'B' + result; break;
			case 12 : result = 'C' + result; break;
			case 13 : result = 'D' + result; break;
			case 14 : result = 'E' + result; break;
			case 15 : result = 'F' + result; break;
			default : result = rem % base + result;
			}
		rem /= base;	
		}
		return result;
	}
	public boolean isPrime(){
		for(int k = 2; k <= Math.sqrt(number); k++)
			if(number % k == 0)
				return false;
		return true;
	}
	public boolean isPalindrome(){
		String back = "";
		int rem = number;
		while(rem > 0){
			back += rem % 10;
			rem /= 10;
		}
		return number == Integer.parseInt(back);
	}
	public boolean isPerfect(){
		int sum = 1;
		for(int k = 2; k < number; k++)
			if(number % k == 0)
				sum += k;
		return sum == number;
	}
	public int gfc(Number a){
		int smaller = Math.min(number, a.getNum());
		for(int k = smaller; k > 1; k--){
			if(a.getNum() % k == 0 && number % k == 0)
				return k;
		}
		return 1;
	}
	public boolean isAmicableWith(Number a){
		int sumOne = 0;
		int sumTwo = 0;
		for(int k = 1; k < number; k++){
			if(number % k == 0)
				sumOne += k;
		}
		for(int j = 1; j < a.getNum(); j++){
			if(a.getNum() % j == 0)
				sumTwo += j;
		}
		return sumOne == a.getNum() && sumTwo == number;
		
	}
	public boolean isHappy(){
		int sum = number;
		for(int k =1; k < 1000000; k++){
			int result = 0;
			int rem = sum; 
		 	while(rem > 0){
		 		result += Math.pow(rem % 10, 2);
		 		rem /= 10;
		 	}
		 	sum = result;
		}
		return sum == 1;
	}
	public String toString(){
		return Integer.toString(number);
	}
}
