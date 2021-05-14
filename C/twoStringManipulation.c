/*
* John Luke Denny
* 5/13/2021
* two functions taking in two strings and comparing the second to the first in some way
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

void squeezeAll(char s1[], char s2[]);
int locOfFirstCharInSecondString(char s1[], char s2[]);
void inSecondStringArray(char s[], bool inSecondString[]);

int main(){
    //statement to test functions on
    char statement1[] = "Testing Functions";
    char statement2[sizeof(&statement1)];
    char statement3[sizeof(&statement1)];

    //make sure all statements start the same
    strcpy(statement2, statement1);
    strcpy(statement3, statement1);

    //strings used against the statements in the functions
    char compare1[] = "Drax";
    char compare2[] = "test func";

    printf("The statement is %s\n\n", statement1);

    squeezeAll(statement1, compare1);
    //should be unchanged
    printf("The statement squeezed with %s is %s\n", compare1, statement1);

    squeezeAll(statement2, compare2);
    //should be "ig io"
    printf("The statement squeezed with %s is %s\n\n", compare2, statement2);


    //should be -1
    printf("The location of the first character shared by %s and %s is at %d\n", statement3, compare1, locOfFirstCharInSecondString(statement3, compare1));
    //should be 0
    printf("The location of the first character shared by %s and %s is at %d\n\n", statement3, compare2, locOfFirstCharInSecondString(statement3, compare2));

    getchar();
    return 1;
}

/*
* creates and array that stores whether or not a character is contained within the string.
* only tracks English alphabet and arabic numerals
*/
void inSecondStringArray(char s[], bool inSecondString[]){
    /*
    * 0-9 values are index
    * a-z/A-Z indexes are 10-35
    */

    for(int i = 0; s[i] != '\0'; i++){
        if(s[i] >= 'A' && s[i] <= 'Z'){
            inSecondString[s[i] - 'A' + 10] = true;
        }
        else if(s[i] >= 'a' && s[i] <= 'z'){
            inSecondString[s[i] - 'a' + 10] = true;
        }
        else if(s[i] >= '0' && s[i] <= '9'){
            inSecondString[s[i] - '0'] = true;
        }
    }
}

/*
* Removes all characters in the first string that are contained in the second string.
* Ignores upper and lower case.
*/
void squeezeAll(char s1[], char s2[]){
    bool inS2[36] = {false};
    inSecondStringArray(s2, inS2);

    char copy[sizeof(&s1)];

    //character offset for each time contained character is true
    int offset = 0;

    for(int i = 0; s1[i] != '\0'; i++){
        //could make one if statement, but would be harder to read
        if(s1[i] >= 'A' && s1[i] <= 'Z' && inS2[s1[i] - 'A' + 10]){
            offset++;
        }
        else if(s1[i] >= 'a' && s1[i] <= 'z' && inS2[s1[i] - 'a' + 10]){
            offset++;
        }
        else if(s1[i] >= '0' && s1[i] <= '9' && inS2[s1[i] - '0']){
            offset++;
        }
        else{
            copy[i - offset] = s1[i];
        }
    }
    strcpy(s1, copy);
}

/*
* Removes all characters in the first string that are contained in the second string.
* Ignores upper and lower case.
*/
int locOfFirstCharInSecondString(char s1[], char s2[]){
    bool inS2[36] = {false};
    inSecondStringArray(s2, inS2);

    for(int i = 0; s1[i] != '\0'; i++){
        //could make one if statement, but would be harder to read
        if(s1[i] >= 'A' && s1[i] <= 'Z' && inS2[s1[i] - 'A' + 10])
            return i;
        else if(s1[i] >= 'a' && s1[i] <= 'z' && inS2[s1[i] - 'a' + 10])
            return i;
        else if(s1[i] >= '0' && s1[i] <= '9' && inS2[s1[i] - '0'])
            return i;
    }

    return -1;
}
