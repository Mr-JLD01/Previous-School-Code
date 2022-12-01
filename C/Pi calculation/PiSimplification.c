#include <stdio.h>

void printPiTerse();
void printPiVerbose();

int main(){
    printf("Terse Version:\n");

    printPiTerse();

    printf("\n\nVerbose Version:\n");

    printPiVerbose();

    printf("\n\n");
    return 0;
}

void printPiTerse(){
    long a = 10000, b = 0, c = 2800, d = 0, e = 0, f[2801], g = 0;

    for(; b-c; )
        f[++b]=a/5;
    for(; d=0, g=c*2; c-=14, printf("%.4ld", e+d/a), e=d%a)
        for(b=c; d+=f[b]*a, f[b]=d%--g, d/=g--,--b; d*=b);
}

void printPiVerbose(){
    long a = 10000, b = 0, c = 2800, d = 0, e = 0, f[2801], g = 0;

    while(b < c){
        b = b + 1;
        f[b] = a / 5;
    }

        d = 0;
    while((g = c * 2)){

        b = c;

        d = d + f[b] * a;
        g = g - 1;
        f[b] = d % g;
        d = d / g;
        g = g - 1;
        b = b - 1;
        while(b >= 1){
            d = d * b;

            d = d + f[b] * a;
            g = g - 1;
            f[b] = d % g;
            d = d / g;
            g = g - 1;
            b = b - 1;
        }

        c = c - 14;
        printf("%.4ld", e + d / a);
        e = d % a;

        d = 0;
    }
}