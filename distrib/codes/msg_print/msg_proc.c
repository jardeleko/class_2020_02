/*
 * msg_proc.c  implementation of the remote procedure call "printmessage"
 */

#include <stdio.h>
#include "msg.h"

int *
printmessage_1_svc(char **argp, struct svc_req *rqstp)
{
	static int  result;

  printf("%s\n", *argp);
  result = 1;

	return &result;
}

