/* Elevens Lab - Tests the Deck Class
 * John Luke Denny
 */
 
public class DeckTester {
	
	public static void main(String[] args) {
		String[] ranks = {"Knave", "Page", "Knight"};
		String[] suits = {"Forks", "Spoons"};
		int[] values = {8, 9, 10};
		
		Deck d = new Deck(ranks, suits, values);
		System.out.print(d);
		System.out.println();
		
		d.deal();
		System.out.println(d);
		System.out.println();
		
		for(int k = 1; k < d.size(); k++){
			d.deal();
		}
		System.out.println(d.isEmpty());
		System.out.println(d);
	}
}
		

