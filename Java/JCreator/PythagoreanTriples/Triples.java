/* Code to find pythagorean triples
 *John Luke Denny
 */
public class Triples {
	private int triUp;
	
	public Triples(){
		this(1);
	}
	
	public Triples(int triple){
		triUp = triple;
	}
	
	public void setNum(int triple){
		triUp = triple;
	}
	
	public int getNum(){
		return triUp;
	}
	public int findGCF(int a, int b, int c){
	int smaller = Math.min(Math.min(a, b), c); 
	for(int i = smaller; i > 1; i--){
			if(a % i == 0 && b % i == 0 && c % i == 0){
				return i; 
			}
		}
		return 1;
	}
	public String toString(){
		String comb = "";
		for(int a = 1; a <= triUp; a++){			
			for(int b = a; b <= triUp; b++){				
				for(int c = b; c <= triUp; c++){
					if (Math.sqrt((a*a) + (b*b)) == c){
						if(findGCF(a, b, c) <= 1)					
                    	comb += a + " " + b + " " + c + "\n"; 
					}
				}
			}
		}
		return comb;	
		
	}
}
