#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <string.h>
#endif

/*
* This method takes a string and removes the trailing
* whitespace. Returns the new string size
*
* routine: RemoveEndingWhiteSpace
*
* return type: int
*
* parameters:
* TheString [char*] - string to remove end of line markers
*
*
* @author John Luke Denny
* @since 3/18/2022
*
*/
int RemoveEndingWhiteSpace(char* TheString){
    int size = strlen(TheString); //keep track of string size
    char end = TheString[size-1]; //keep track of the final non-null char of string

    while( end == ' ' || end == '\t' || end == '\n'){
        end = TheString[(--size) - 1];
        if(size == 0)
            break;
    }
    TheString[size] = '\0';
    return size;
}

/*
* This method takes an input file and
* returns an integer from input file
*
* routine: InputInteger
*
* return type: int
*
* parameters:
* inFile [FILE] - an input file
*
*
* @author John Luke Denny
* @since 3/12/2022
*
*/
int InputInteger(FILE* InFile){
    int returnVal;
    fscanf(InFile, "%d\n", &returnVal);
    return returnVal;
}

/*
* This method takes an input file and
* returns a float from input file
*
* routine: InputFloat
*
* return type: float
*
* parameters:
* inFile [FILE] - an input file
*
*
* @author John Luke Denny
* @since 3/12/2022
*
*/
float InputFloat(FILE* InFile){
    float returnVal;
    fscanf(InFile, "%f\n", &returnVal);
    return returnVal;
}

/*
* This method takes an input file and
* sets a string to a line of input
*
* routine: InputString
*
* return type: void
*
* parameters:
* inFile [FILE] - an input file
* InString [char*] - string input will be written to
*
*
* @author John Luke Denny
* @since 3/12/2022
*
*/
void InputString(FILE* InFile, char* InString){
    fscanf(InFile, "%[^\n]\n", InString);
}