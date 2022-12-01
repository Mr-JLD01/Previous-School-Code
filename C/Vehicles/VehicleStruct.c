#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <string.h>
#endif
#ifndef VEHICLE_STRUCT
#define VEHICLE_STRUCT
#include "VehicleStruct.h"
#include "FileUtility.h"
#endif
#include <stdlib.h>


/*
* This method takes an input file and
* and creates and returns a boat struct
*
* routine: BoatInput
*
* return type: Vehicle*
*
* parameters:
* inFile [FILE] - an input file
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
Vehicle* BoatInput(FILE* inFile){
    Vehicle *boat = (Vehicle*)malloc(sizeof(Vehicle)); //return variable
    int wordSize; //keeps track of string size

    boat->type = 1;

    boat->make = (char*)malloc(50*sizeof(char));
    InputString(inFile, boat->make);
    wordSize = RemoveEndingWhiteSpace(boat->make);
    boat->make = (char*)realloc(boat->make, wordSize*sizeof(char));

    boat->model = (char*)malloc(50*sizeof(char));
    InputString(inFile, boat->model);
    wordSize = RemoveEndingWhiteSpace(boat->model);
    boat->model = (char*)realloc(boat->model, wordSize*sizeof(char));

    boat->year = InputInteger(inFile);

    boat->vin = (char*)malloc(50*sizeof(char));
    InputString(inFile, boat->vin);
    wordSize = RemoveEndingWhiteSpace(boat->vin);
    boat->vin = (char*)realloc(boat->vin, wordSize*sizeof(char));

    boat->motorType = (char*)malloc(50*sizeof(char));
    InputString(inFile, boat->motorType);
    wordSize = RemoveEndingWhiteSpace(boat->motorType);
    boat->motorType = (char*)realloc(boat->motorType, wordSize*sizeof(char));

    return boat;
}

/*
* This method takes an output file and
* a boat struct to print the output
* to the file
*
* routine: BoatOutput
*
* return type: void
*
* parameters:
* outFile [FILE] - an output file
* boat [Vehicle*] - boiat struct
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
void BoatOutput(FILE* outFile, Vehicle* boat){
    fprintf(outFile, "%d %s %s\nVIN: %s\nMotor: %s\n\n", boat->year, boat->make, boat->model, boat->vin, boat->motorType);
}

/*
* This method takes an input file and
* and creates and returns a truck struct
*
* routine: TruckInput
*
* return type: Vehicle*
*
* parameters:
* inFile [FILE] - an input file
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
Vehicle* TruckInput(FILE* inFile){
    Vehicle *truck = (Vehicle*)malloc(sizeof(Vehicle)); //return variable
    int wordSize; //keeps track of string size

    truck->type = 3;

    truck->make = (char*)malloc(50*sizeof(char));
    InputString(inFile, truck->make);
    wordSize = RemoveEndingWhiteSpace(truck->make);
    truck->make = (char*)realloc(truck->make, wordSize*sizeof(char));

    truck->model = (char*)malloc(50*sizeof(char));
    InputString(inFile, truck->model);
    wordSize = RemoveEndingWhiteSpace(truck->model);
    truck->model = (char*)realloc(truck->model, wordSize*sizeof(char));

    truck->year = InputInteger(inFile);

    truck->vin = (char*)malloc(50*sizeof(char));
    InputString(inFile, truck->vin);
    wordSize = RemoveEndingWhiteSpace(truck->vin);
    truck->vin = (char*)realloc(truck->vin, wordSize*sizeof(char));

    truck->numDoors = InputInteger(inFile);

    truck->towingCapacity = InputFloat(inFile);

    return truck;
}

/*
* This method takes an output file and
* a truck struct to print the output
* to the file
*
* routine: TruckOutput
*
* return type: void
*
* parameters:
* outFile [FILE] - an output file
* truck [Vehicle*] - truck struct
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
void TruckOutput(FILE* outFile, Vehicle* truck){
    fprintf(outFile, "%d %s %s\nVIN: %s\nDoors: %d\nMax Towing Capacity: %.2f\n\n", truck->year, truck->make, truck->model, truck->vin, truck->numDoors, truck->towingCapacity);
}


/*
* This method takes an input file
* and creates and returns a car struct
*
* routine: CarInput
*
* return type: Vehicle*
*
* parameters:
* inFile [FILE] - an input file
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
Vehicle* CarInput(FILE* inFile){
    Vehicle *car = (Vehicle*)malloc(sizeof(Vehicle)); //return variable
    int wordSize; //keeps track of string size

    car->type = 2;

    car->make = (char*)malloc(50*sizeof(char));
    InputString(inFile, car->make);
    wordSize = RemoveEndingWhiteSpace(car->make);
    car->make = (char*)realloc(car->make, wordSize*sizeof(char));

    car->model = (char*)malloc(50*sizeof(char));
    InputString(inFile, car->model);
    wordSize = RemoveEndingWhiteSpace(car->model);
    car->model = (char*)realloc(car->model, wordSize*sizeof(char));

    car->year = InputInteger(inFile);

    car->vin = (char*)malloc(50*sizeof(char));
    InputString(inFile, car->vin);
    wordSize = RemoveEndingWhiteSpace(car->vin);
    car->vin = (char*)realloc(car->vin, wordSize*sizeof(char));

    car->numDoors = InputInteger(inFile);

    car->rearConfig = (char*)malloc(50*sizeof(char));
    InputString(inFile, car->rearConfig);
    wordSize = RemoveEndingWhiteSpace(car->rearConfig);
    car->rearConfig = (char*)realloc(car->rearConfig, wordSize*sizeof(char));

    return car;
}

/*
* This method takes an output file and
* a car struct to print the output
* to the file
*
* routine: CarOutput
*
* return type: void
*
* parameters:
* outFile [FILE] - an output file
* car [Vehicle*] - car struct
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
void CarOutput(FILE* outFile, Vehicle* car){
    fprintf(outFile, "%d %s %s\nVIN: %s\nDoors: %d\nRear Configuration: %s\n\n", car->year, car->make, car->model, car->vin, car->numDoors, car->rearConfig);
}