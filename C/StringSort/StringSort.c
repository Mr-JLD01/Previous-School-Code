#ifndef FILE_INCLUDE
#define FILE_INCLUDE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#endif
#include "StringArrayHelp.h"

int GetFiles(int numArgs, char* args[], FILE** inFile, FILE** outFile);

/*
* This program takes a file input, reads the file, and
* sorts the words from the file. Then,
* the sorted words are output to a new file.
*
* CSC 3304 Programming project No. 5
*
* @author John Luke Denny
* @since 4/10/2022
*
*/
int main(int argc, char *argv[]){
    char inputBuffer[100]; //input buffer for incoming words
    FILE *input; //File inputs will be taken from
    FILE *output; //File that will be written to
    int size = 0; //size of dynamic array
    int wordSize; //size of word
    char **words = (char**)malloc(10*sizeof(char*)); //dynamic string array
    char *word = (char*)malloc(sizeof(char)); //string the input buffer is copied into


    if(GetFiles(argc, argv, &input, &output)){
        return -1; //Improper usage or FILE not found. Exact error found in returned value
    }

    while(!feof(input)){
        InputString(input, inputBuffer);
        wordSize = RemoveEndingWhiteSpace(inputBuffer);
        word = (char*)malloc((wordSize + 1) * sizeof(char));
        strcpy(word, inputBuffer);
        size++;
        if(size > 10){
            words = realloc(words, size * sizeof(char*));
        }
        *(words + size - 1) = word;
    }

    BubbleSort(words, size);

    for(int i = 0; i < size; i++){
        fprintf(output, "%s\n", *(words + i));
    }

    for(int i = 0; i < size; i++){
        free(*(words + i)); //word is freed through this loop
    }

    free(words);
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
* @since 4/4/2022
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
