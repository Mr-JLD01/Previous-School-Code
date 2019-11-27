/*John Luke Denny
2/18/2019
Computer Science I
This program creates has the user input a letter and it outputs the ICAO word for the letter
*/

#include <iostream>
#include <string>

using namespace std;

string ICAO(char letter) { // takes the inputted letter and returns the ICAO word
	if (letter == 'A' || letter == 'a')
		return "Alpha";
	else if (letter == 'B' || letter == 'b')
		return "Bravo";
	else if (letter == 'C' || letter == 'c')
		return "Charlie";
	else if (letter == 'D' || letter == 'd')
		return "Delta";
	else if (letter == 'E' || letter == 'e')
		return "Echo";
	else if (letter == 'F' || letter == 'f')
		return "Foxtrot";
	else if (letter == 'G' || letter == 'g')
		return "Golf";
	else if (letter == 'H' || letter == 'h')
		return "Hotel";
	else if (letter == 'I' || letter == 'i')
		return "India";
	else if (letter == 'J' || letter == 'j')
		return "Juliet";
	else if (letter == 'K' || letter == 'k')
		return "Kilo";
	else if (letter == 'L' || letter == 'l')
		return "Lima";
	else if (letter == 'M' || letter == 'm')
		return "Mike";
	else if (letter == 'N' || letter == 'n')
		return "November";
	else if (letter == 'O' || letter == 'o')
		return "Oscar";
	else if (letter == 'P' || letter == 'p')
		return "Papa";
	else if (letter == 'Q' || letter == 'q')
		return "Quebec";
	else if (letter == 'R' || letter == 'r')
		return "Romeo";
	else if (letter == 'S' || letter == 's')
		return "Sierra";
	else if (letter == 'T' || letter == 't')
		return "Tango";
	else if (letter == 'U' || letter == 'u')
		return "Uniform";
	else if (letter == 'V' || letter == 'v')
		return "Victor";
	else if (letter == 'W' || letter == 'w')
		return "Whiskey";
	else if (letter == 'X' || letter == 'x')
		return "X-ray";
	else if (letter == 'Y' || letter == 'y')
		return "Yankee";
	else if (letter == 'Z' || letter == 'z')
		return "Zulu";
	else
		return "Please type a letter and nothing else";
}

int main() {
	char letter; // the letter to be used in function ICAO

	cout << "Please enter in a singular letter for its ICAO word :: ";
	cin >> letter;
	cout << "The ICAO word is -- " << ICAO(letter) << endl;
	cin.get();
	cout << "Please enter in a singular letter for its ICAO word :: ";
	cin >> letter;
	cout << "The ICAO word is -- " << ICAO(letter) << endl;
	cin.get();
	cout << "Please enter in a singular letter for its ICAO word :: ";
	cin >> letter;
	cout << "The ICAO word is -- " << ICAO(letter) << endl;
	cin.get();

	cin.get();
	return 0;
}