/*John Luke Denny
2 / 11 / 2019
Computer Science I
This program has the user input a time in 24hr format and outputs the written form of the time
*/

#include <iostream>
#include <string>

using namespace std;

string wordHour(int hour) { //writes out the word form of the hour inputted
	switch (hour) {
	case 1: 
	case 13:return "One";
	case 2:
	case 14:return "Two";
	case 3:
	case 15:return "Three";
	case 4:
	case 16:return "Four";
	case 5:
	case 17:return "Five";
	case 6:
	case 18:return "Six";
	case 7:
	case 19:return "Seven";
	case 8:
	case 20:return "Eight";
	case 9:
	case 21:return "Nine";
	case 10:
	case 22:return "Ten";
	case 11:
	case 23:return "Eleven";
	case 12:
	case 0:return "Twelve";
	default: return "Not a valid hour";
	}
}

string teenMinutes(char oneMinutes) { // writes out the word form of the minutes from the range 10 - 19
	switch (oneMinutes) {
	case '0': return "Ten";
	case '1': return "Eleven";
	case '2': return "Twelve";
	case '3': return "Thirteen";
	case '4': return "Fourteen";
	case '5': return "Fifteen";
	case '6': return "Sixteen";
	case '7': return "Seventeen";
	case '8': return "Eighteen";
	case '9': return "Nineteen";
	default:return "Try entering a number";
	}
}

string singleMinutes(char oneMinutes) { // writes out the inputed minute from the one's place
	switch (oneMinutes) {
	case '0': return "";
	case '1': return "One";
	case '2': return "Two";
	case '3': return "Three";
	case '4': return "Four";
	case '5': return "Five";
	case '6': return "Six";
	case '7': return "Seven";
	case '8': return "Eightn";
	case '9': return "Nine";
	default:return "Try entering a number";
	}
}

string wordMinutes(char tenMinutes, char oneMinutes) {// writes the word form of the minutes
	switch (tenMinutes) {
	case '0': return singleMinutes(oneMinutes);
	case '1': return teenMinutes(oneMinutes);
	case '2': return "Twenty " + singleMinutes(oneMinutes);
	case '3': return "Thirty " + singleMinutes(oneMinutes);
	case '4': return "Fourty " + singleMinutes(oneMinutes);
	case '5': return "Fifty " + singleMinutes(oneMinutes);
	default: return "and not valid minutes";
	}
}

int main() {
	int hour; // user inputted hour
	char tenMinutes; // user inputted ten's place minutes
	char oneMinutes; // user inputted one's place minutes
	string dayHalf = "AM"; // is to notate am or pm :: default is am

	cout << "Enter a time in 24hr format without the colon :: ";
	cin >> hour >> tenMinutes >> oneMinutes;
	cout << endl;
	if (hour > 12) // used to determine AM or PM
		dayHalf = "PM";
	if (hour == 0 && tenMinutes == '0' && oneMinutes == '0') // starts with the special cases of midnight and noon
		cout << "Midnight" << endl;
	else if (hour == 12 && tenMinutes == '0' && oneMinutes == '0')
		cout << "Noon" << endl;
	else cout << wordHour(hour) << " " << wordMinutes(tenMinutes, oneMinutes) << " " << dayHalf;
	
	cin.get();
	cin.get();
	return 0;
}