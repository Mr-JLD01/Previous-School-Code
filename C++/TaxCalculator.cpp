/*John Luke Denny
3 / 14 / 2019
Computer Science I
This program calculates taxes given a user inputted income nad filing status
*/

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main() {
	int statusCode = 0;
	float taxableIncome = 0;
	float taxAmt;
	double taxPercent;
	float taxRange; // range of tax bracket
	while (statusCode != 9) { 

		do {//has user input a status code for one of the five options
			cout << "PLease input an integer for your filing status. \n(1)Single \n(2)Married Filing Jointly \n(3)Married Filing Separately \n(4)Head of Household \n(9)End Process \n:: ";

			cin >> statusCode;
			cout << endl << endl;
			if ((statusCode != 9) && ((statusCode > 4) || (statusCode < 1)))
				cout << "Please enter one of the options given." << endl;
		} while ((statusCode != 9) && ((statusCode > 4) || (statusCode < 1))); // makes sure the status code is valid

		do { // has user input taxable income if status code is not 9
			if (statusCode == 9) //exits loop is status code is 9
				break;
			cout << "Please enter your taxable income, which must be greater than $3000.00 :: ";

			cin >> taxableIncome;
			cout << endl;
			if (taxableIncome < 3000.0)
				cout << "Please enter a taxable income within the parameter set." << endl;
		} while (taxableIncome < 3000.0);
		float tax = taxableIncome; // creates a copy to be manipulated without losing orininal taxableIncome
		taxAmt = 0; //resets tax amount
		taxPercent = .12; // resets tax percent
		switch (statusCode) { //calculates tax owed
		case 1: taxRange = 7550;
			if (tax > taxRange) {
				taxAmt += taxRange * taxPercent;
				tax -= taxRange;
				taxRange = 23099;
				taxPercent = .16;
				if (tax > taxRange) {
					taxAmt += taxRange * taxPercent;
					tax -= taxRange;
					taxRange = 43549;
					taxPercent = .20;
					if (tax > taxRange) {
						taxAmt += taxRange * taxPercent;
						tax -= taxRange;
						taxRange = 80599;
						taxPercent = .28;
						if (tax > taxRange) {
							taxAmt += taxRange * taxPercent;
							tax -= taxRange;
							taxRange = 181749;
							taxPercent = .32;
							if (tax > taxRange) {
								taxAmt += taxRange * taxPercent;
								tax -= taxRange;
								taxPercent = .40;
							}
						}
					}
				}
			}
			taxAmt += (tax - 1) * taxPercent;
			break;
		case 2: taxRange = 15100;
			if (tax > taxRange) {
				taxAmt += taxRange * taxPercent;
				tax -= taxRange;
				taxRange = 46199;
				taxPercent = .16;
				if (tax > taxRange) {
					taxAmt += taxRange * taxPercent;
					tax -= taxRange;
					taxRange = 62399;
					taxPercent = .20;
					if (tax > taxRange) {
						taxAmt += taxRange * taxPercent;
						tax -= taxRange;
						taxRange = 64749;
						taxPercent = .28;
						if (tax > taxRange) {
							taxAmt += taxRange * taxPercent;
							tax -= taxRange;
							taxRange = 148099;
							taxPercent = .32;
							if (tax > taxRange) {
								taxAmt += taxRange * taxPercent;
								tax -= taxRange;
								taxPercent = .40;
							}
						}
					}
				}
			}
			taxAmt += (tax - 1) * taxPercent;
			break;
		case 3: taxRange = 7550;
			if (tax > taxRange) {
				taxAmt += taxRange * taxPercent;
				tax -= taxRange;
				taxRange = 23099;
				taxPercent = .16;
				if (tax > taxRange) {
					taxAmt += taxRange * taxPercent;
					tax -= taxRange;
					taxRange = 31199;
					taxPercent = .20;
					if (tax > taxRange) {
						taxAmt += taxRange * taxPercent;
						tax -= taxRange;
						taxRange = 32374;
						taxPercent = .28;
						if (tax > taxRange) {
							taxAmt += taxRange * taxPercent;
							tax -= taxRange;
							taxRange = 74049;
							taxPercent = .32;
							if (tax > taxRange) {
								taxAmt += taxRange * taxPercent;
								tax -= taxRange;
								taxPercent = .40;
							}
						}
					}
				}
			}
			taxAmt += (tax - 1) * taxPercent;
			break;
		case 4: taxRange = 10750;
			if (tax > taxRange) {
				taxAmt += taxRange * taxPercent;
				tax -= taxRange;
				taxRange = 30299;
				taxPercent = .16;
				if (tax > taxRange) {
					taxAmt += taxRange * taxPercent;
					tax -= taxRange;
					taxRange = 64949;
					taxPercent = .20;
					if (tax > taxRange) {
						taxAmt += taxRange * taxPercent;
						tax -= taxRange;
						taxRange = 65649;
						taxPercent = .28;
						if (tax > taxRange) {
							taxAmt += taxRange * taxPercent;
							tax -= taxRange;
							taxRange = 164899;
							taxPercent = .32;
							if (tax > taxRange) {
								taxAmt += taxRange * taxPercent;
								tax -= taxRange;
								taxPercent = .40;
							}
						}
					}
				}
			}
			taxAmt += (tax - 1) * taxPercent;
			break;
		case 9:break;
		}

		switch (statusCode) {// outputs filing status, taxable income, and tax amount
		case 1: cout << "Filing status: Single \nTaxable Income: " << taxableIncome << "\nTax Amount: " << fixed << setprecision(2) << taxAmt << endl; break;
		case 2: cout << "Filing status: Married Filing Jointly \nTaxable Income: " << taxableIncome << "\nTax Amount: " << fixed << setprecision(2) << taxAmt << endl; break;
		case 3: cout << "Filing status: Mrried Filing Separately \nTaxable Income: " << taxableIncome << "\nTax Amount: " << fixed << setprecision(2) << taxAmt << endl; break;
		case 4: cout << "Filing status: Head of Household \nTaxable Income: " << taxableIncome << "\nTax Amount: " << fixed << setprecision(2) << taxAmt << endl; break;
		case 9:break;
		}
		
	}
	
	cin.get();

	return 0;
}

