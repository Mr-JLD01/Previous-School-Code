#include <stdio.h>
#include <stdlib.h>

//converts a signed integer to a binary string
void int2bitstr(int I, char str[]){
    int copy = I; //copies the integer as to not alter it
    for(int counter = 0; counter < 32; counter++){//does for every bit
        if(copy < 0){//since int is signed if there is a sign bit, it will be less than zero and known as a 1
            str[counter] = '1';
            copy = copy << 1;
        }else if(copy >= 0){
            str[counter] = '0';
            copy = copy << 1;
        }

    }
    str[32] = '\0';//adds the null termination
}

unsigned f2u(float f){
    union{
        unsigned u;
        float f;
    }v;
    v.u = 0;
    v.f = f;
    return v.u;
}

//returns the exponent value of a float
int get_exp_value(float f){
    unsigned u = f2u(f);
    u = u >> 23;//gets rid of the significand
    if(u == 511)//checks for infinity / NaN
        return -128;
    else if(u != 0){ //case for normalized floats
        char exp = u - 127;//used to truncate to one byte and git rid of a potential sign bit
        return exp;
    }
    else //case for denormalized floats
        return -126;
}

int test(int *num){
    *num = 5 * (*num);
    printf("num was changed to %d\n", *num);
    return *num;
}

int main(){

    char str[33];
    int var;
    float f = 22;
    int k = 20;

    printf("k is %d\n", k);
    test(&k);
    printf("k is now %d\n\n", k);

    printf("%f shifted right 23: %d\n%f exp value is: %d\n",f, f2u(f)>>23,f, get_exp_value(f));
    printf("Enter an integer :: ");
    scanf("%d", &var);
    getchar();
    
    int2bitstr(var, str);
    printf("%d in binary is %s\n", var, &str);
    printf("%f to unsigned is %d\n", f, f2u(f));

    getchar();
    return 0;
}

