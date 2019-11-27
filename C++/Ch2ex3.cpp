#include "Ch2ex3.h"
/*John Luke Denny
1/28/2019
Computer Science I
This program creates an 8 by 8 grid of blanks and stars
*/

#include <iostream>
#include <string>
using namespace std;

	//const string blank_star = "  *   *   *   *";    // Defines the line that starts with a blank and ends with a star that more closely matches the look from the textbook
	//const string star_blank = "*   *   *   *  ";    // Defines the line that starts with a star and ends with a blank that more closely matches the look from the textbook
	const string blank_star = " * * * *";    // Defines the line that starts with a blank and ends with a star that is for an 8 by 8
	const string star_blank = "* * * * ";    // Defines the line that starts with a star and ends with a blank that is for an 8 by 8
	
	int main()
	{
		cout << blank_star << endl;
		cout << star_blank << endl;
		cout << blank_star << endl;
		cout << star_blank << endl;
		cout << blank_star << endl;
		cout << star_blank << endl;
		cout << blank_star << endl;
		cout << star_blank << endl;
		cin.get();
		return 0;
	}
