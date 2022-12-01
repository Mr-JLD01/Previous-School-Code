#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STRING_LENGTH 1024
int numElements = 0;

void freeArray(char ***stringArray);
void addString(char *string, char ***stringArray);
void populateArray(char ***stringArray);
void printStringArray(char **stringArray);
int cmpfunc(const void *a, const void *b);
int removeEndingWhiteSpace(char *string);

int main()
{

    char **arr = (char **)malloc(sizeof(char *));

    populateArray(&arr);

    printStringArray(arr);

    printf("============================\n");
    printf("Sorting...\n");
    qsort(arr, numElements, sizeof(char *), cmpfunc);
    printf("============================\n");

    printStringArray(arr);

    freeArray(&arr);
    return 0;
}

void freeArray(char ***stringArray)
{
    for (int i = 0; i < numElements; i++)
    {
        free((*stringArray)[i]);
    }
    free(*stringArray);
}

void addString(char *string, char ***stringArray)
{
    numElements++;
    *stringArray = (char **)realloc(*stringArray, sizeof(char *) * numElements);
    (*stringArray)[numElements - 1] = string;
}

void populateArray(char ***stringArray)
{
    int elementsToGet = 0;
    int size = 0;

    printf("Enter the number of strings to get:: ");
    fscanf(stdin, "%d", &elementsToGet);
    getchar();
    char *string = NULL;

    for (int i = 0; i < elementsToGet; i++)
    {
        string = (char *)malloc(sizeof(char) * MAX_STRING_LENGTH);
        printf("Please enter a string:: ");
        fgets(string, MAX_STRING_LENGTH, stdin);
        if(strlen(string) >= MAX_STRING_LENGTH){
            string[MAX_STRING_LENGTH] = '\0';
        }
        size = removeEndingWhiteSpace(string);
        string = (char *)realloc(string, sizeof(char) * size);
        fflush(stdin);

        addString(string, stringArray);
    }
}

void printStringArray(char **stringArray)
{
    for (int i = 0; i < numElements; i++)
    {
        printf("%s\n", (stringArray)[i]);
    }
}

int cmpfunc(const void *a, const void *b)
{
    return strcmp(*(char **)a, *(char **)b);
}

int removeEndingWhiteSpace(char *string)
{
    int size = strlen(string);   // keep track of string size
    char end = string[size - 1]; // keep track of the final non-null char of string

    while (end == ' ' || end == '\t' || end == '\n')
    {
        end = string[(--size) - 1];
        if (size == 0)
            break;
    }
    string[size] = '\0';
    return size;
}