/*
 * printmsg.c   program for printing a message
 */

#include <stdio.h>
#include <stdlib.h>

int printmessage(char *msg)
{
    int result;

    printf("%s\n", msg);
    result = 1;

    return(result);
}

int main(int argc, char *argv[])
{
    int result;
    char *message;

    if (argc != 2) {
        fprintf(stderr, "usage %s message\n", argv[0]);
    }
    message = argv[1];

    result = printmessage(message);
    if (result == 0) {
        fprintf(stderr, "%s: couldn't print your message\n", argv[0]);
        exit(1);
    }

     exit(0);
}

