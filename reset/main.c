#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "color.h"
#include "choose.h"
#include "game.h"
#include "gamelist.h"
#include "show.h"
#include "login.h"

#define UNUSED_PARAMETER(x) (void)x

int main(int argc, char **argv)
{
    UNUSED_PARAMETER(argc);
	UNUSED_PARAMETER(argv);
	init();

    int run = 1;
	char ch;
	int choose;

	while (run) {
		  system("clear");

back1:
          printf("\n按Enter继续\n");
          while((ch = getchar()) != '\n' && ch != EOF);

          system("clear");
          Login_UI();

				/*scanf("%d", &choose);*/

         /* while((ch = getchar()) != '\n' && ch != EOF);*/

          choose = getchar();

          switch (choose) {
              case '1': 
                  while((ch = getchar()) != '\n' && ch != EOF);
                  regist();
                  break;
              case '2':
                  while((ch = getchar()) != '\n' && ch !=EOF);
                  logining();
                  run = 0;
                  break;
              case '3':
                  exit(1);
                  break;
              default:
                  while((ch = getchar()) != '\n' && ch != EOF);
                  printf("enter error");
                  break;
          }
    }

    run = 1;

    while (run) {

           system("clear");
           printf("\t\t\n按Enter继续\n");
           
           while((ch = getchar()) != '\n' && ch != EOF);
           
           system("clear");
           Choose_Game();

           choose = getchar();
           
           switch (choose) {
               case '1':
                   /*while((ch = getchar()) != '\n' && ch != EOF);*/
                   guess_choose();
                   break;
               case '2':
                  /* while((ch = getchar()) != '\n' && ch != EOF);*/
                   crazy_choose();
                   break;
               case '3':
                   goto back1;
                   break;
               default:
                   /*while((ch = getchar()) != '\n' && ch != EOF);*/
                   printf("\t\t\nEnter error\n");
                   break;
           }
    }
    return 0;
}
