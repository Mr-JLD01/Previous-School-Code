/*John Luke Denny
4 / 23 / 2019
Computer Science I
This program calculates taxes given a user inputted income and filing status
*/

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

//functions to be used
int getStatusCode();
float getTaxIncome(int code);
float calcTaxAmt(int code, float income);
void displayResults(int code, float income, float taxAmount, string status);

int main() {

	//initilize variables
	int statusCode = 0;
	float taxableIncome = 0;
	float taxAmt;
	string filingStatus[] = { "Single", "Married Filing Jointly", "Married Filing Separately", "Head of Household" }; // status descriptions 

	while (statusCode != 9) {//ends program when statusCode equals 9
		statusCode = getStatusCode();//user inputs filing status
		taxableIncome = getTaxIncome(statusCode); // user inputs taxable income
		taxAmt = calcTaxAmt(statusCode, taxableIncome); //calculates taxes owed
		if(statusCode != 9) //check to avoid exception
		displayResults(statusCode, taxableIncome, taxAmt, filingStatus[statusCode - 1]);//outputs results
	}

	cin.get();

	return 0;
}

int getStatusCode(){//user inputs filing status
	int code;
	do {//has user input a status code for one of the five options
	cout << "PLease input an integer for your filing status. \n(1)Single \n(2)Married Filing Jointly \n(3)Married Filing Separately \n(4)Head of Household \n(9)End Process \n:: ";

	cin >> code;
	cout << endl << endl;
	if ((code != 9) && ((code > 4) || (code < 1)))
		cout << "Please enter one of the options given." << endl;
	} while ((code != 9) && ((code > 4) || (code < 1))); // makes sure the status code is valid
	return code;
}

float getTaxIncome(int code) {// user inputs taxable income
	int income = 0;
	do { // has user input taxable income if status code is not 9
		if (code == 9) //exits loop is status code is 9
			break;
		cout << "Please enter your taxable income, which must be greater than $3000.00 :: ";

		cin >> income;
		cout << endl;
		if (income < 3000.0)
			cout << "Please enter a taxable income within the parameter set." << endl;
	} while (income < 3000.0);
	return income;
}

float calcTaxAmt(int code, float income){//calculates taxes owed
	double taxRate[] = {.12, .16, .2, .28, .32, .4}; //array of tax rates

	//different tax bracket ranges
	int singleRange[] = {7550, 23099, 43549, 80599, 181749};
	int marriedSepRange[] = {15100, 46199, 62399, 64749, 148099};
	int marriedJointRange[] = {7550, 23099, 31199, 32374, 74049};
	int hohRange[] = {10750, 30299, 64949, 65649, 164899};

	float taxAmt = 0; //tax owed return
	int x = 0; //position holder for arrays

	switch (code) { //calculates tax owed
	case 1:
		if (income > singleRange[x]) {
			taxAmt += singleRange[x] * taxRate[x];
			income -= singleRange[x];
			x++;
			if (income > singleRange[x]) {
				taxAmt += singleRange[x] * taxRate[x];
				income -= singleRange[x];
				x++;
				if (income > singleRange[x]) {
					taxAmt += singleRange[x] * taxRate[x];
					income -= singleRange[x];
					x++;
					if (income > singleRange[x]) {
						taxAmt += singleRange[x] * taxRate[x];
						income -= singleRange[x];
						x++;
						if (income > singleRange[x]) {
							taxAmt += singleRange[x] * taxRate[x];
							income -= singleRange[x];
							x++;
						}
					}
				}
			}
		}
		return taxAmt + (income - 1) * taxRate[x];
		break;
	case 2:
		if (income > marriedSepRange[x]) {
			taxAmt += marriedSepRange[x] * taxRate[x];
			income -= marriedSepRange[x];
			x++;
			if (income > marriedSepRange[x]) {
				taxAmt += marriedSepRange[x] * taxRate[x];
				income -= marriedSepRange[x];
				x++;
				if (income > marriedSepRange[x]) {
					taxAmt += marriedSepRange[x] * taxRate[x];
					income -= marriedSepRange[x];
					x++;
					if (income > marriedSepRange[x]) {
						taxAmt += marriedSepRange[x] * taxRate[x];
						income -= marriedSepRange[x];
						x++;
						if (income > marriedSepRange[x]) {
							taxAmt += marriedSepRange[x] * taxRate[x];
							income -= marriedSepRange[x];
							x++;
						}
					}
				}
			}
		}
		return taxAmt + (income - 1) * taxRate[x];
		break;
	case 3:
		if (income > marriedJointRange[x]) {
			taxAmt += marriedJointRange[x] * taxRate[x];
			income -= marriedJointRange[x];
			x++;
			if (income > marriedJointRange[x]) {
				taxAmt += marriedJointRange[x] * taxRate[x];
				income -= marriedJointRange[x];
				x++;
				if (income > marriedJointRange[x]) {
					taxAmt += marriedJointRange[x] * taxRate[x];
					income -= marriedJointRange[x];
					x++;
					if (income > marriedJointRange[x]) {
						taxAmt += marriedJointRange[x] * taxRate[x];
						income -= marriedJointRange[x];
						x++;
						if (income > marriedJointRange[x]) {
							taxAmt += marriedJointRange[x] * taxRate[x];
							income -= marriedJointRange[x];
							x++;
						}
					}
				}
			}
		}
		return taxAmt + (income - 1) * taxRate[x];
		break;
	case 4:
		if (income > hohRange[x]) {
			taxAmt += hohRange[x] * taxRate[x];
			income -= hohRange[x];
			x++;
			cout << taxAmt << endl;
			if (income > hohRange[x]) {
				taxAmt += hohRange[x] * taxRate[x];
				income -= hohRange[x];
				x++;
				cout << taxAmt << endl;
				if (income > hohRange[x]) {
					taxAmt += hohRange[x] * taxRate[x];
					income -= hohRange[x];
					x++;
					if (income > hohRange[x]) {
						taxAmt += hohRange[x] * taxRate[x];
						income -= hohRange[x];
						x++;
						cout << taxAmt << endl;
						if (income > hohRange[x]) {
							taxAmt += hohRange[x] * taxRate[x];
							income -= hohRange[x];
							x++;
							cout << taxAmt << endl;
						}
					}
				}
			}
		}
		return taxAmt + (income - 1) * taxRate[x];
		break;
	case 9:break;
	}
}

void displayResults(int code, float income, float taxAmount, string status) {//outputs results
	if (code != 9)
		cout << "Filing status: " << status << "\nTaxable Income: " << income << "\nTax Amount: " << fixed << setprecision(2) << taxAmount << endl << endl;
	
}