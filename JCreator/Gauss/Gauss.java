/* Gaussian Elimination
 * John Luke Denny
 */
 
 import java.util.Arrays;
 
 
public class Gauss {
	private double[][] coeff;
	private double[] constant;
	private double[][] equation;
	private double[] solutions;
	
	public Gauss(double[][] system, double[] equate){
		coeff = system;
		constant = equate;
		solutions = new double[equate.length];
		equation = solvingFor(coeff, constant);
	}
	
	public void setCoeffs(double[][] system){
		coeff = system;
	}
	
	public void setConstant(double[] equate){
		constant = equate;
	}
	
	public void setEquation(double[][] system, double[] equate){
		equation = solvingFor(coeff, constant);
	}
	
	public double[][] solvingFor(double[][] system, double[] equate){
		double[][] solving = new double[coeff.length][coeff[0].length + 1];
		for(int r = 0; r < solving.length; r++){
			for(int c = 0; c < solving[r].length; c++){
				if(c < coeff[r].length)
					solving[r][c] = coeff[r][c];
				else
					solving[r][c] = constant[r];
			}
		}
		return solving;
	}
	
	public int rowsToSwap(double[][] solves, int startRow, int col){
		for(int r = startRow; r < solves.length; r++){
			if(solves[r][col] != 0)
				return r;
		}
		return startRow;
	}
	
	public void rowSwapper(double[][] solves, int startRow, int swapRow){
		double[] copy = solves[startRow];
		
		solves[startRow] = solves[swapRow];
		solves[swapRow] = copy;
		
	}
	
	public void elimination(double[][] solves, int startRow, int startCol){
		double place = 0.0;
		double start = 0.0;
		for(int r = startRow; r < solves.length; r++){
			start = solves[r][startCol];
			for(int c = startCol; c < solves[r].length; c++){
				place = solves[startRow - 1][c];
				solves[r][c] -= (start * place);
			}
		}
		
	}
	
	public void division(double[][] solves, int row, int startCol){
		double divisor = solves[row][startCol];
		
		for(int c = startCol; c < solves[row].length; c++){
			solves[row][c] /= divisor;
		}
		
	}
	
	public boolean solve(){
		int rS = 0;
		for(int r = 0; r < equation.length; r++){
			if(r == equation.length - 1 && equation[r][r] == 0){
				return false;	
			}
			rS = rowsToSwap(equation, r, r);
			rowSwapper(equation, r, rS);
			division(equation, r, r);
			if(r < equation.length - 1)
				elimination(equation, r + 1, r);
			
		}
		
		solutions[equation.length - 1] = equation[equation.length - 1][equation.length];
		
		for(int r = equation.length - 2; r >= 0; r--){
			solutions[r] = equation[r][equation.length];
			for(int c = equation.length - 1; c > r; c--){
				solutions[r] -= equation[r][c] * solutions[c];
			}
		}
		return true;
	}
	
	public String toString(){
		if(!solve())
			return "NO UNIQUE SOLUTION!";
		String out = "";
		char let = 'a';
		for(double d : solutions){
			out += let++ + " = " + d + "\n";
		}
		return out;
	}
}
