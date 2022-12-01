#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#endif
#ifndef VEHICLE_STRUCT
#define VEHICLE_STRUCT
#include "VehicleStruct.h"
#include "FileUtility.h"
#endif


int GetFiles(int numArgs, char* args[], FILE** inFile, FILE** outFile);
void BubbleSort(Vehicle** arr, int size);
void PointerSwap(Vehicle** ptr1, Vehicle** ptr2);

/*
* This program takes a file input, reads the file, and
* organizes the data into an array of vehicle structs. Then,
* the array is sorted by year and output to a file.
*
* CSC 3304 Programming project No. 6
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
int main(int argc, char *argv[]){
    FILE *input; //File inputs will be taken from
    FILE *output; //File that will be written to
    char type[10]; //string to determine which vehicle information to format in the write
    typedef enum{
        BOAT = 1,
        CAR,
        TRUCK
    } Vehicles;
    int i; //loop variable
    Vehicles vehicleType; // a rudendant enumeration since strings are the input and need if's to set the variable
    Vehicle** vehicleArray = (Vehicle**)malloc(sizeof(Vehicle*));
    Vehicle* v = (Vehicle*)malloc(sizeof(Vehicle));
    int arrSize = 0;

    if(GetFiles(argc, argv, &input, &output)){
        return -1; //Improper usage or FILE not found. Exact error found in returned value
    }

    while(!feof(input)){

        fscanf(input, "%s\n", type);

        if(strcmp(type, "boat")==0){
            vehicleType = BOAT;
        }else if(strcmp(type, "truck")==0){
            vehicleType = TRUCK;
        }else if(strcmp(type, "car")==0){
            vehicleType = CAR;
        }else{
            printf("%s is not a valid vehicle!\n", type);
            break; //If vehicle is invalid, we don't want to write to file
        }

        switch(vehicleType){
            case BOAT:
                v = BoatInput(input);
                vehicleArray = (Vehicle**)realloc(vehicleArray, (++arrSize)*sizeof(Vehicle*));
                *(vehicleArray + arrSize - 1) = v;
                break;
            case CAR:
                v = CarInput(input);
                vehicleArray = (Vehicle**)realloc(vehicleArray, (++arrSize)*sizeof(Vehicle*));
                *(vehicleArray + arrSize - 1) = v;
                break;
            case TRUCK:
                v = TruckInput(input);
                vehicleArray = (Vehicle**)realloc(vehicleArray, (++arrSize)*sizeof(Vehicle*));
                *(vehicleArray + arrSize - 1) = v;
                break;
            default:printf("No vehicle provided\n");
        }
    }

    BubbleSort(vehicleArray, arrSize);

    for(i = 0; i < arrSize; i++){
        vehicleType = vehicleArray[i]->type;
        switch (vehicleType)
        {
        case BOAT:
            BoatOutput(output, *(vehicleArray + i));
            break;
        case CAR:
            CarOutput(output, *(vehicleArray + i));
            break;
        case TRUCK:
            TruckOutput(output, *(vehicleArray + i));
            break;
        default:
            printf("Not a valid vehicle!!\n");
        }
    }

    for(i = 0; i < arrSize; i++){
        free(*(vehicleArray + i));
    }

    free(vehicleArray);
    fclose(input);
    fclose(output);

    return 0;
}

/*
* This method sets the file pointers to
* the appropriate files based on command-line
* arguments
*
* routine: GetFiles
*
* return type: int
*
* parameters:
* numArgs [int] - number of arguments in args
* args [array of strings] - command-line arguments
* inFile [FILE pointer] - pointer to an input file
* outFile [FILE pointer] - pointer to an output file
*
* Return values:
* 0: Successful run
* -1: FILE not found
* -2: Improper usage
*
* @author John Luke Denny
* @since 3/12/2022
*
*/
int GetFiles(int numArgs, char* args[], FILE** inFile, FILE** outFile){
    if(numArgs == 1){
        if(!(*inFile = fopen("./TestInput.txt", "r"))){
            printf("File not found!\n");
            return -1;
        }
        *outFile = fopen("./out.txt", "w");
    }else if((numArgs)% 2 == 0 || numArgs > 5){
        printf("Usage:\n");
        printf("./VehicleOrganizer\nor\n");
        printf("./VehicleOrganizer {-i, -o} [input/output file path] {-i, -o} [input/output file path]\n");
        printf("Options\n");
        printf("\t-i: input file\n\t-o: output file\n\n");

        return -2;

    }else{
        for(int i = 1; i < numArgs; i++){
            if(strcmp(args[i], "-i") == 0){
                if(!(*inFile = fopen(args[++i], "r"))){
                    printf("Input file not found!\n");
                    return -1;
                }
            }else if(strcmp(args[i], "-o") == 0){
                if(!(*outFile = fopen(args[++i], "w"))){
                    printf("Output file not found!\n");
                    return -1;
                }
            }else{
                printf("arg[%d]: %s\n", i, args[i]);
                printf("Usage:\n");
                printf("./VehicleOrganizer\nor\n");
                printf("./VehicleOrganizer {-i, -o} [input/output file path] {-i, -o} [input/output file path]\n");
                printf("Options\n");
                printf("\t-i: input file\n\t-o: output file\n\n");

                return -2;
            }
        }
        if(!*inFile){
            if(!(*inFile = fopen("./TestInput.txt", "r"))){
                printf("File not found!\n");
                return -1;
            }
        }
        if(!*outFile){
            *outFile = fopen("./out.txt", "w");
        }
    }

    return 0;
}

/*
* This method sorts a dynamic vehicle array in
* increasing year order
*
* routine: BubbleSort
*
* return type: void
*
* parameters:
* arr [Vehicle**] - dynamic Vehicle array to sort
* size [int] - size of the dynamic array
*
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
void BubbleSort(Vehicle** arr, int size){
    for(int i = 0; i < size - 1; i++){
        for(int j = 0; j < size - i - 1; j++){
            if(arr[j]->year > arr[j + 1]->year){
                PointerSwap((arr + j), (arr + j + 1));
            }
        }
    }
}

/*
* This method swaps two vehicle pointer addresses
*
* routine: PointerSwap
*
* return type: void
*
* parameters:
*   ptr1 [Vehicle**] - address of pointer to swap 1
*   ptr2 [Vehicle**] - address of pointer to swap 2
*
*
* @author John Luke Denny
* @since 4/18/2022
*
*/
void PointerSwap(Vehicle** ptr1, Vehicle** ptr2){
    Vehicle* tmp = *ptr1;
    *ptr1 = *ptr2;
    *ptr2 = tmp;
}