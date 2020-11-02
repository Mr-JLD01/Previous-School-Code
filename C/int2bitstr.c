#include <stdio.h>
#include <stdlib.h>

//converts a signed integer to a binary string
void int2bitstr(int I, char *str){
    int copy = I; //copies the integer as to not alter it
    for(int counter = 0; counter < 32; counter++){//does for every bit
        if(copy < 0){//since int is signed if there is a sign bit, it will be less than zero and known as a 1
            str[counter] = '1';
            copy = copy << 1;
        }else if(copy > 0){
            str[counter] = '0';
            copy = copy << 1;
        }
        else{
            str[counter] = '0';
        }
    }
    str[32] = "\0";//adds the null termination
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

int test(int *k){
    *k = 5 * (*k);
    printf("%d", *k);
    return 1;
}

int main(){

    char str[32];
    int var;
    float f = 0;
    int *k = 20;
    printf("%p is the result!", test(*k));
    //printf("%f shifted right 23: %d\n%f exp value is: %d",f, f2u(f)>>23,f, get_exp_value(f));
    //scanf("%d", &var);
    //int2bitstr(var, str);
    //printf("%d in binary is %s", var, str);
    //printf("%f to unsigned is %d", f, f2u(f));

    return 0;
}

