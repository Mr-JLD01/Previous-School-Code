/* John Luke Denny
4/19/19
Computer Science I
This program includes a class that manipulates aspects of time and tests the class
*/

#include <iostream>
#include <string>

using namespace std;

class Time { //class for time
public:
	Time() { //default constructor
		minute = 0;
		second = 0;
	}
	Time( int min, int sec) { // constructor
		if (sec > 59) {
			minute = min + sec / 60;
			second = sec % 60;
		}
		else {
			minute = min;
			second = sec;
		}
	}
	int getMinutes() { //accessor method
		return minute;
	}
	int getSeconds() {//accessor method
		return second;
	}
	int getTotalTimeSec() { //returns total time in seconds
		return minute * 60 + second;
	}
	string compareTimes(Time time2) { //compares two times
		if (isEqualTime(time2) )
			return "The times are equal";
		else if (isGreaterTime(time2))
			return "The second time is greater";
		else if (isLessTime(time2))
			return "The second time is less than the first";
		else
			"IDK???";
	}
	bool isEqualTime(Time time2) { //determines if two times are equal
		return getTotalTimeSec() == Time(time2).getTotalTimeSec();
	}
	bool isGreaterTime(Time time2) { //determines if second time is greater
		return getTotalTimeSec() <= Time(time2).getTotalTimeSec();
	}
	bool isLessTime(Time time2) {//determines if second time is less
		return getTotalTimeSec() >= Time(time2).getTotalTimeSec();
	}
	void addTimes(Time time2) {//adds two times
		int min3;
		int sec3;

		min3 = minute + time2.getMinutes();
		if (second + time2.getSeconds() > 60) {
			min3 += 1;
			sec3 = second + time2.getSeconds() - 60;
		}
		else
			sec3 = second + time2.getSeconds();

		cout << min3 << " : " << sec3 << endl;
	}
	void subtractTimes(Time time2) { // subtracts two times
		int min3;
		int sec3;
		
		if (isGreaterTime(time2))
			cout << "0 : 00" << endl;
		else {
			min3 = minute - time2.getMinutes();
			if (second - time2.getSeconds() < 0) {
				min3 -= 1;
				sec3 = second - time2.getSeconds() + 60;
			}
			cout << min3 << " : " << sec3 << endl;
		}
		
	}
private:
	int minute;
	int second;
};

int main() {
	Time time1 = Time(2, 30);
	Time time2 = Time(6, 15);
	Time time3 = Time(4, 65); // would be 5 min 5 sec

	//tests getMinutes and getSeconds functions
	cout << "time 1 is " << time1.getMinutes() << " : " << time1.getSeconds() << endl;
	cout << "time 2 is " << time2.getMinutes() << " : " << time2.getSeconds() << endl;
	cout << "time 3 is " << time3.getMinutes() << " : " << time3.getSeconds() << endl;

	//tests getTotalTimeSec
	cout << "Total time of time 1 is " << time1.getTotalTimeSec() << " seconds" << endl;
	cout << "Total time of time 2 is " << time2.getTotalTimeSec() << " seconds" << endl;
	cout << "Total time of time 3 is " << time3.getTotalTimeSec() << " seconds" << endl;

	//tests compare times
	cout << time1.compareTimes(time2) << endl;
	cout << time1.compareTimes(time3) << endl;
	cout << time2.compareTimes(time1) << endl;
	cout << time2.compareTimes(time3) << endl;
	cout << time3.compareTimes(time1) << endl;
	cout << time3.compareTimes(time2) << endl;

	//tests addTimes
	time1.addTimes(time2);
	time1.addTimes(time3);
	time3.addTimes(time2);

	//tests subtractTimes
	time1.subtractTimes(time2);
	time1.subtractTimes(time3);
	time2.subtractTimes(time1);
	time2.subtractTimes(time2);
	time3.subtractTimes(time1);
	time3.subtractTimes(time2);
	

	cin.get();
	return 0;
}