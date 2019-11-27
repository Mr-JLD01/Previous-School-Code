/*John Luke Denny
2/11/2019
Computer Science I
This program creates has the user input 12 temperatures and outputs the average while writing the temperatures and the changes to a data file
*/

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <cmath>

using namespace std;

float TempChange(float first, float second) { // calculates the chnage in temperature from a first temp to a second temp 
	return second - first;
}

float Average(float sum) { // averages the temperatures
	return sum / 12;
}

int main() {
	ofstream outData;
	outData.open("tempdata.dat");// insert the file location of "tempdata.dat" in directory the cureent place is the location on my own pc

	float sum = 0;         // sum of temps
	float tempOne;     // first temp for change
	float tempTwo;     //second temp for change

	cout << "Please enter a temperature :: ";
	cin >> tempOne;
	outData << tempOne << endl;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;
	cout << "Please enter a temperature :: ";
	cin >> tempTwo;
	outData << tempTwo << ' ' << TempChange(tempOne, tempTwo) << endl;
	tempOne = tempTwo;
	sum += tempOne;

	cin.get();

	cout << "The average of the temperature's entered is :: " << fixed << Average(sum);
	
	cin.get();
	outData.close();

	return 0;
}
