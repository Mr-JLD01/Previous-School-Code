#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#endif

typedef struct{
    int type;
    int year;
    char* make;
    char* model;
    char* vin;
    int numDoors;
    union
    {
        float towingCapacity;
        char* rearConfig;
        char* motorType;
    };
} Vehicle;

Vehicle* BoatInput(FILE* inFile);
void BoatOutput(FILE* outFile, Vehicle* boat);

Vehicle* TruckInput(FILE* inFile);
void TruckOutput(FILE* outFile, Vehicle* truck);

Vehicle* CarInput(FILE* inFile);
void CarOutput(FILE* outFile, Vehicle* car);
