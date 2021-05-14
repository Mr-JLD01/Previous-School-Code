/*
* John Luke Denny
* 5/13/2021
* three functions that alter a subset of a number's bits
*/

#include <stdio.h>

void setBits(int *x, int p, int n, int y);
void invertBits(int *x, int p, int n);
void rightRotateBits(int *x, int n);
int getBits(int x, int p, int n);
int getFlag(int p, int n);

int main(){
    int example = 0;
    int y = 63;
    //must be less that 16
    int p = 5;
    // must be <= p
    int n = 3;

    setBits(&example, p, n, y);
    printf("Example num is now %d after having %d bits of %d at position %d\n", example, n, y, p);

    example = 63;
    invertBits(&example, p, n);
    printf("Example num is now %d after having %d bits inverted at %d\n", example, n, p);

    example = 31;
    rightRotateBits(&example, n);
    printf("Example num is now %d after being rotated right %d bits\n", example, n);

    return 1;
}

/*
* returns n bits of a number x starting at position p
*/
int getBits(int x, int p, int n){
    return (x >> (p + 1 - n)) & ~(~0 << n);
}

/*
* creates flag to clear bits in a number x
*/
int getFlag(int p, int n){
    return ~(~(~0 << n) << (p + 1 - n));
}

/*
* takes rightmost n bits of y and places those in the n bits starting at position p in x
*/
void setBits(int *x, int p, int n, int y){
    int bits = getBits(y, n, n) << (p + 1 - n);
    int flag = getFlag(p, n);

    *x &= flag;
    *x += bits;
}

/*
* inverts n bits in x starting at position p
*/
void invertBits(int *x, int p, int n){
    int copy = *x;
    int bits = getBits(~copy, p, n) << (p + 1 - n);
    int flag = getFlag(p, n);

    *x &= flag;
    *x += bits;
}

/*
* rotates x n bits to the right
*/
void rightRotateBits(int *x, int n){
    int copy = *x;
    int bits = getBits(copy, n, n) << (32 - n);

    *x >> n;
    *x += bits;
}