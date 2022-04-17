/* Tests shuffle method in the Deck class
 * DFrederick
 */
 
public class ShuffleTester {
	
	public static void main(String[] args) {
		
		String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
		String[] suits = {"spades", "hearts", "diamonds", "clubs"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		
		Deck d = new Deck(ranks, suits, values);
		System.out.println(d);
		System.out.println();
		d.shuffle();
		System.out.println(d);
	}	
}
