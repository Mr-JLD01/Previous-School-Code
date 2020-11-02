/* John Luke Denny
3/22/19
Computer Science I
This program sees the user input a number of rooms then the dimensions of the rooms and of the square tile to be used to floor said rooms. It outputs the number of boxes needed and how many extra tiles.
*/

#include <iostream>
#include <string>

using namespace std;

int getRoomTiles(int widthFt, int widthIn, int lengthFt, int lengthIn, int tileSize);// functions to be used
int getBoxAmount(int tileTotal);

int main() {
	int numRooms; 
	int tileSize;
	int roomWidthFt;
	int roomWidthIn;
	int roomLengthFt;
	int roomLengthIn;
	int totalTiles = 0;
	do {// loop to ensure user inputs a valid number of rooms
		cout << "Enter number of rooms: ";
		cin >> numRooms;
	} while (numRooms < 1);

	do {// loop to ensure user inputs valid measurement of tile
		cout << "Enter size of tile in inches: ";
		cin >> tileSize;
	} while (tileSize < 1);
	do {// loop for every room
		do {// loop to ensure user inputs valid measurement for room width
			cout << "Enter room width (feet and inches, separated by a space): ";
			cin >> roomWidthFt >> roomWidthIn;
		} while (roomWidthFt < 0 || roomWidthIn > 11 || roomWidthIn < 0);

		do {// loop to ensure user inputs valid measurement for room length
			cout << "Enter room length (feet and inches, separated by a space): ";
			cin >> roomLengthFt >> roomLengthIn;
		} while (roomLengthFt < 0 || roomLengthIn > 11 || roomLengthIn < 0);

		cout << "Room requires " << getRoomTiles(roomWidthFt, roomWidthIn, roomLengthFt, roomLengthIn, tileSize) << " tiles." << endl; // number of tiles a room needs
		totalTiles += getRoomTiles(roomWidthFt, roomWidthIn, roomLengthFt, roomLengthIn, tileSize);// updates total number of tiles

		numRooms--; // decreases room count left
	} while (numRooms > 0);
	cout << "Total tiles required is " << totalTiles << "." << endl;
	cout << "Number of boxes needed is " << getBoxAmount(totalTiles) << "." << endl;
	cout << "There will be " << getBoxAmount(totalTiles) * 20 - totalTiles << " extra tiles." << endl;

	cin.get();
	cin.get();
	return 0;
}

int getRoomTiles(int widthFt, int widthIn, int lengthFt, int lengthIn, int tileSize) { // calculates the number of tiles for a room given length and width of the room and the tile size
	int numTilesWidth = 0;
	int numTilesLength = 0;
	widthIn += widthFt * 12; // width in inches
	lengthIn += lengthFt * 12; // length in inches

	numTilesWidth = widthIn / tileSize;
	if (widthIn % tileSize > 0)
		numTilesWidth++;

	numTilesLength = lengthIn / tileSize;
	if (lengthIn % tileSize > 0)
		numTilesLength++;

	return numTilesLength * numTilesWidth;
}

int getBoxAmount(int tileTotal) { // calculates the number of boxes needed given the total amount of tiles
	int numBoxes = 0;

	numBoxes = tileTotal / 20;
	if (tileTotal % 20 > 0)
		numBoxes++;

	return numBoxes;
}