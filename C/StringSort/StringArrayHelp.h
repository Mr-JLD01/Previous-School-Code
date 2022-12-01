#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#endif

void PointerSwap(char** ptr1, char** ptr2);
void BubbleSort(char** words, int size);
int RemoveEndingWhiteSpace(char* TheString);
void InputString(FILE* InFile, char InString[]);