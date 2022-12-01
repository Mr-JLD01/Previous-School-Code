#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void sigint_handler(int sig);

int main(){

    for(int i = 1; 1; i++){
        if (signal(SIGINT, sigint_handler) == SIG_ERR){
            ;
        }
        printf("%d\n", i);
    }

    return 1;
}

void sigint_handler(int sig){
    write(1, "\nI'm melting!! mmeeellttiiiingg.......\n", 40);
    fflush(stdout);
    exit(0);
}