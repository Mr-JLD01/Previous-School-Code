#include <stdio.h>
#include <stdlib.h>

typedef struct funcs {
 int (*openit)(char *name, int prot);
 void (*closeit)(void);
} funcs;

int repeatName(char *name, int count);
void closingTime();
void f(funcs *structure);

int main(){
    funcs *test = (funcs *)malloc(sizeof(funcs));
    test->openit = repeatName;
    test->closeit = closingTime;
    f(test);
    return 0;
}

int repeatName(char *name, int count){
    for(int i = 0; i < count; i++){
        printf("%d: %s\n", i + 1, name);
    }
    return count;
}

void closingTime(){
    printf("Closing Time is performed by Semisonic\n");
}

void f(funcs *structure){
    structure->openit("Hi", 4);
    structure->closeit();
}