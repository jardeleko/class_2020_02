#include <stdio.h>
#include <rpc/rpc.h>
#include "date.h"

int main(int argc, char **argv) {
  long *lresult; /* return from bin_date */
  char **sresult; /* return from str_date */
  char *server = "localhost"; /* default */
  CLIENT *cl; /* rpc handle */

  if (argc != 2) {
    fprintf(stderr, "usage: %s hostname\n", argv[0]);
    exit(1);
  }
  server = argv[1];

  /* Create client handle */
  if ((cl = clnt_create(server, DATE_PROG, DATE_VERS, "udp")) == NULL) {
    /* can't establish connection with server */
    clnt_pcreateerror(server);
    exit(2);
  }

  /* First call the remote procedure bin_date */
  if ((lresult = bin_date_1(NULL, cl)) == NULL) {
    clnt_perror(cl, server);
    exit(3);
  }
  printf("time on host %s = %ld\n", server, *lresult);

  /* Now call the remote procedure str_date */
  if ((sresult = str_date_1(lresult, cl)) == NULL) {
    clnt_perror(cl, server);
    exit(4);
  }
  printf("date on host %s = %s", server, *sresult);

  clnt_destroy(cl); /* done with the handle */

  exit(0);
}

