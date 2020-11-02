/* John Luke Denny
4/12/19
Computer Science I
This program translates a letter, word, or phrase into ICAO phonetics
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

	string  phrase; //string to be translated
	string iCAO[] = {"Alpha ","Bravo ","Charlie ","Delta ","Echo ","Foxtrot ","Golf ","Hotel ","India ","Juliet ","Kilo ","Lima ","Mike ","November ","Oscar ","Papa ","Quebec ","Romeo ","Sierra ","Tango ","Uniform ","Victor ","Whiskey ","X-ray ","Yankee ","Zulu " }; //array declaration with the ICAO alphabet

	cout << "Please input a letter, word, or phrase with no punctaution to have it converted to ICAO until only the number zero is inputted :: ";// prompt for user with exit condition of '0'
	cin >> phrase;
	cout << endl;

	do {
		if (phrase == "0") //exit condition
			break;
		for (int p = 0; p < phrase.length(); p++) { //cycles through the places of the string phrase
			cout << iCAO[toupper(phrase.at(p)) - 'A']; //outputs the correct ICAO given the character
		}
		cout << endl;
		cin >> phrase;
	} while (phrase.size() > 1);

	cin.get();
	return 0;
}