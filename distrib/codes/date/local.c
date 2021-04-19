#include <stdio.h>
#include <time.h>
#include <rpc/rpc.h>
#include "date.h"

long bin_date() {
	long result;

    result = time((long *)0);
	return result;
}

char *str_date(long bintime) {
	char *result;

    result = ctime(&bintime);

	return result;
}

int main(int argc, char **argv) {
  long lresult; /* return from bin_date */
  char *sresult; /* return from str_date */

  if (argc != 1) {
    fprintf(stderr, "usage: %s\n", argv[0]);
    exit(1);
  }

  /* First call the remote procedure bin_date */
  lresult = bin_date();
  printf("time = %ld\n", lresult);

  /* Now call the remote procedure str_date */
  sresult = str_date(lresult);
  printf("date = %s", sresult);

  exit(0);
}

