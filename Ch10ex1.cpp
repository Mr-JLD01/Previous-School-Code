/*John Luke Denny
4/5/19
Computer Scuence I
This program takes takes a user inputted weight, in pounds, and a planet for which the person's weight on that planet is determined
*/

#include <iostream>
#include <string>
#include <iomanip> //to set precision of float output

using namespace std;

enum PlanetaryMass{MERCURY, VENUS, EARTH, MOON, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO, VOID}; //spacial bodies and a void for a default and check variable

PlanetaryMass getBody(string mass); // gets spacial body
float newWeight(float weight, PlanetaryMass body); // calculates a person's weight on the given planet

int main() {
	string planet;
	float weight;

	cout << "Please enter a weight, in pounds, to the tenths place :: ";
	cin >> weight;
	cout << endl;

	do {
		cout << "Please enter one of the planetary masses listed as a single word with no spaces \n[Mercury, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto] :: ";
		cin >> planet;
		cout << endl;
		if (getBody(planet) == VOID) //check to see if input is valid
			cout << "Please enter in one of the options listed." << endl;
	} while (getBody(planet) == VOID); // check to see if input is valid

	cout << "Your weight on " << planet << " is " << fixed << setprecision(2)<< newWeight(weight, getBody(planet)) << " pounds.";

	cin.get();
	cin.get();
	return 0;
}

PlanetaryMass getBody(string mass) { //determines the spacial body based on a user inputted string
	switch (toupper(mass.at(0))) {
	case 'M': if (toupper(mass.at(1)) == 'E')
		return MERCURY;
			  else if (toupper(mass.at(1)) == 'O')
		return MOON;
			  else
		return MARS;
	case 'V': return VENUS;
	case 'E': return EARTH;
	case 'J': return JUPITER;
	case 'S': return SATURN;
	case 'U': return URANUS;
	case 'N': return NEPTUNE;
	case 'P': return PLUTO;
	default: return VOID;
	}

}

float newWeight(float weight, PlanetaryMass body) { //calculates weight on a spacial body
	switch (body) {
	case MERCURY: return weight * .4155;
	case MOON: return weight * .166;
	case MARS: return weight * .3507;
	case VENUS: return weight * .8975;
	case EARTH: return weight;
	case JUPITER: return weight * 2.5374;
	case SATURN: return weight * 1.0677;
	case URANUS: return weight * .8947;
	case NEPTUNE: return weight * 1.1794;
	case PLUTO: return weight * .0899;
	default: return 0;
	}
}