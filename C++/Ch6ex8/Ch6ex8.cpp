/*John Luke Denny
2/18/2019
Computer Science I
This program takes parts mail messages and outputs and writes on a data file the email addresses of the input file
*/

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
	ifstream inData;
	ofstream outData;

	inData.open("mail.dat");
	outData.open("addresses.dat");

	string word;

	inData >> word; // used to check each word in the input data
	while (inData) { // cycles through he words of the data
		if (word.find("@") < word.length()) { // checks to see if it is an email address and outputs and writes it to a file
			outData << word << endl;
			cout << word << endl;
		} 
		inData >> word;
	}

	inData.close();
	outData.close();
	cin.get();
	return 0;

}