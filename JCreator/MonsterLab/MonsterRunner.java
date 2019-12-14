/* Tests the Monster class
 * John Luke Denny
 */

import java.util.List;
import java .util.Collections;
import java.util.ArrayList;
 
public class MonsterRunner{
	
   	public static void main(String[] args){
		Monster zero = new Monster();
		Monster one = new Monster(8);
		Monster sue = new Monster(9, 4);
		Monster harry = new Monster(1, 2, 3);
	
		System.out.println("John Luke Denny");
	
		System.out.println("\nzero Monster :: " + zero);		
		System.out.println("\none Monster :: " + one);
		System.out.println("\nsue Monster :: " + sue);
		System.out.println("\nharry Monster :: " + harry);

		System.out.println("\nchanging harry's properties ");				
		harry.setHeight(7);
		harry.setWeight(6);
		harry.setAge(5);
		System.out.println("\nharry Monster :: " + harry);

		System.out.println("\ncloning harry");	
		sue = (Monster)harry.clone();
		System.out.println("\nsue Monster :: " + sue);

		Monster mOne = new Monster(33,33,11);
		Monster mTwo = new Monster(55,33,11);

		System.out.println("\nMonster 1 :: " + mOne);
		System.out.println("\nMonster 2 :: " + mTwo);

		System.out.print("\nmOne.equals(mTwo) == ");
		System.out.println(mOne.equals(mTwo));

		System.out.print("\nmOne.compareTo(mTwo) == ");
		System.out.println(mOne.compareTo(mTwo));
		System.out.print("\nmTwo.compareTo(mOne) == ");
		System.out.println(mTwo.compareTo(mOne));
		
		List<Monster> m1 = new ArrayList<Monster>();
		List<Monster> m2 = new ArrayList<Monster>();
		for(int h = 0; h <= 10; h++){
			for(int w = 0; w <= 10; w++){
				for(int a = 0; a <= 10; a++){
					m1.add(new Monster(h, w, a));
					m2.add(new Monster(h, w, a));
				}
			}
		}
		Collections.sort(m1);
		Collections.sort(m2);
		for(Monster m : m1)
			for(Monster n : m2)
				System.out.println("Monster: " + m + " and Monster: " + n + " gives " + m.compareTo(n));
	}
}