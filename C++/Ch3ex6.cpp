/*John Luke Denny
2/3/2019
Computer Science I
This program computes the number of combinations of a given number 'n', 'r' times
*/

#include <iostream>
#include <string>
#include <cmath>
#include <iomanip>
using namespace std;

double factorial(int num) { // uses Stirling's formula to find the approximation of a factorial for numbers greater than 0
	double factorial = exp(-1 * num) * pow(num, num) * sqrt(2 * 3.14159265358979323846 * num);
	return factorial;
}

double combinations(int n, int r) { // finds the number of combinations
	double combin = factorial(n) / (factorial(r) * factorial(n - r));
	return combin;
}

int main()
{
	double numTeam = combinations(18, 3);
	cout << fixed << setprecision(0) << "Number of teams arrangements " << numTeam << endl;
	cin.get(); // press enter to end
	return 0; 

}

