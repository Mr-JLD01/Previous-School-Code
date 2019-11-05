/*John Luke Denny
3/29/19
Computer Scuence I
This program takes a data stream and converts it into a cipher using a version of the Caesar cipher 
*/

#include <fstream>
#include <string>

using namespace std;

char Rot13(char manip); // functions to be used
void WriteTranslatedChar(ofstream& outFile, char cipher);

int main() {
	ifstream inData;  //data streams to use
	ofstream outData;
	string inputStr; //string to evaluate characters

	inData.open("letter.txt");
	outData.open("output.rot13.txt");

	getline(inData, inputStr);

	while (inData) { // loops through indata until it reaches the end of it
		for (int p = 0; p < inputStr.length(); p++) { // loops through the input string character by character
			WriteTranslatedChar(outData, Rot13(inputStr.at(p))); // writes the translated char to the outdata
		}
		outData << "\n"; 
		getline(inData, inputStr);
	}
	
	inData.close();
	outData.close();
	return 0;
}

char Rot13(char manip) {//translates a char into another using the rot13 cipher
	switch (manip) {
	case 'A': return 'N'; break;
	case 'a': return 'n'; break;
	case 'B': return 'O'; break;
	case 'b': return 'o'; break;
	case 'C': return 'P'; break;
	case 'c': return 'p'; break;
	case 'D': return 'Q'; break;
	case 'd': return 'q'; break;
	case 'E': return 'R'; break;
	case 'e': return 'r'; break;
	case 'F': return 'S'; break;
	case 'f': return 's'; break;
	case 'G': return 'T'; break;
	case 'g': return 't'; break;
	case 'H': return 'U'; break;
	case 'h': return 'u'; break;
	case 'I': return 'V'; break;
	case 'i': return 'v'; break;
	case 'J': return 'W'; break;
	case 'j': return 'w'; break;
	case 'K': return 'X'; break;
	case 'k': return 'x'; break;
	case 'L': return 'Y'; break;
	case 'l': return 'y'; break;
	case 'M': return 'Z'; break;
	case 'm': return 'z'; break;
	case 'N': return 'A'; break;
	case 'n': return 'a'; break;
	case 'O': return 'B'; break;
	case 'o': return 'b'; break;
	case 'P': return 'C'; break;
	case 'p': return 'c'; break;
	case 'Q': return 'D'; break;
	case 'q': return 'd'; break;
	case 'R': return 'E'; break;
	case 'r': return 'e'; break;
	case 'S': return 'F'; break;
	case 's': return 'f'; break;
	case 'T': return 'G'; break;
	case 't': return 'g'; break;
	case 'U': return 'H'; break;
	case 'u': return 'h'; break;
	case 'V': return 'I'; break;
	case 'v': return 'i'; break;
	case 'W': return 'J'; break;
	case 'w': return 'j'; break;
	case 'X': return 'K'; break;
	case 'x': return 'k'; break;
	case 'Y': return 'L'; break;
	case 'y': return 'l'; break;
	case 'Z': return 'M'; break;
	case 'z': return 'm'; break;
	default: return manip; break;
	}
}

void WriteTranslatedChar(ofstream& outFile, char cipher) {// writes the translated character to an out file
	outFile << cipher;
}
