/* tests Gauss
 * John Luke Denny
 */
public class GuassTester {
	public static void main(String[] args){
		
		System.out.println("John Luke Denny");
		
		double[][] c = {{4.0, 8.0, 4.0}, {2.0, 1.0, -4.0}, {3.0, -1.0, 2.0}};
		
		double[] d = {80.0, 7.0, 22.0};
		
		Gauss test = new Gauss(c, d);
		
		test.solve();    
			
		System.out.println(test);
		
		double[][] a = {{0.0, 1.0, 1.0, -2.0}, {1.0, 2.0, -1.0, 0.0}, {2.0, 4.0, 1.0, -3.0},{1.0, -4.0, -7.0, -1.0}};
		
		double[] b = {-3.0, 2.0, -2.0, -19.0};
		
		Gauss test2 = new Gauss(a, b);
		
		test2.solve();    
			
		System.out.println(test2);
		
		double[][] e = {{2.0, 7.0, 1.0}, {11.0, 25.0, 1.0}, {5.0, 9.0, 1.0}};
		double[] f = {-53.0, -746.0, -106.0};
		
		Gauss test3 = new Gauss(e, f);
		
		test3.solve();    
			
		System.out.println(test3);
	}
}
