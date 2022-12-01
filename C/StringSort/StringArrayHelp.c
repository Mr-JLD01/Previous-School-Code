#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#endif

/*
* This method swaps two string pointer addresses
*
* routine: PointerSwap
*
* return type: void
*
* parameters:
*   ptr1 [char**] - address of pointer to swap 1
*   ptr2 [char**] - address of pointer to swap 2
*
*
* @author John Luke Denny
* @since 4/10/2022
*
*/
void PointerSwap(char** ptr1, char** ptr2){
    char* tmp = *ptr1;
    *ptr1 = *ptr2;
    *ptr2 = tmp;
}

/*
* This method sorts a dynamic string array in
* increasing alphabetical order
*
* routine: BubbleSort
*
* return type: void
*
* parameters:
* words [char**] - dynamic string array to sort
* size [int] - size of the dynamic array
*
*
* @author John Luke Denny
* @since 4/10/2022
*
*/
void BubbleSort(char** words, int size){
    for(int i = 0; i < size - 1; i++){
        for(int j = 0; j < size - i - 1; j++){
            if(strcmp(*(words + j), *(words + j + 1)) > 0){
                PointerSwap((words + j), (words + j + 1));
            }
        }
    }
}

/*
* This method takes a string and removes the trailing
* whitespace. Returns the new string size
*
* routine: RemoveEndingWhiteSpace
*
* return type: int
*
* parameters:
* TheString [char[]] - string to remove end of line markers
*
*
* @author John Luke Denny
* @since 4/10/2022
*
*/
int RemoveEndingWhiteSpace(char TheString[]){
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
* sets a string to a line of input
*
* routine: InputString
*
* return type: void
*
* parameters:
* inFile [FILE] - an input file
* InString [char[]] - string input will be written to
*
*
* @author John Luke Denny
* @since 4/10/2022
*
*/
void InputString(FILE* InFile, char InString[]){
    fscanf(InFile, "%[^\n]\n", InString);
}