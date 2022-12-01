#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{

    unsigned long *p = malloc(sizeof(unsigned long));
    *p = 0xdeadbeefcafeba00;
    // need to cast so pointer arithmetic is for char not long
    unsigned char *c = (unsigned char *)p;
    int i;

    printf("%lx\n", *p);

    // output the individual bytes of the unsigned long value...or not?

    printf("Little Endian\n");
    for (i = 0; i < sizeof(unsigned long); i++)
    {
        printf("%02x ", *c);
        c++;
    }
    printf("\n\n");

    printf("Big Endian\n");
    c = (unsigned char *)p + (sizeof(unsigned long) - 1);
    for (i = 0; i < sizeof(unsigned long); i++)
    {
        printf("%02x ", *c);
        // use '--' to work our way up the stack
        c--;
    }
    printf("\n");
    return 0;
}
