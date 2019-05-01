#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>

#include "color.h"
#include "choose.h"
#include "game.h"
#include "gamelist.h"
#include "show.h"
#include "login.h"
#include "debug.h"

static void deal_ctrl_c(int sig);

#define UNUSED_PARAMETER(x) (void)x

int main(int argc, char *argv[])
{
    UNUSED_PARAMETER(argc);
	UNUSED_PARAMETER(argv);
	init();

    int run = 1;
	char ch;
	int choose;
    int rt = 0;
    
	while (run) {
	    system("clear");
back1:
        printf("\n按Enter继续\n");
        while((ch = getchar()) != '\n' && ch != EOF);
        signal(SIGINT,deal_ctrl_c);

        system("clear");
        login_ui();
        choose = getchar();

        switch (choose) {
            case '1': 
                while((ch = getchar()) != '\n' && ch != EOF);
                rt = regist();
                if (rt == PLAYER_FILE_ERROR) {
                    DEBUG("REGIST:player file open or creatr error");
                }
                
                break;

            case '2':
                while((ch = getchar()) != '\n' && ch !=EOF);
                rt = logining();
                if (rt == PLAYER_FILE_ERROR) {
                    DEBUG("LOGIN:player file open error");
                }
                
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
        signal(SIGINT,deal_ctrl_c);
        
        system("clear");
        choose_game();

        choose = getchar();
        
        switch (choose) {
            case '1':
                guess_choose();
                break;

            case '2':
                crazy_choose();
                break;

            case '3':
                goto back1;
                break;

            default:
                printf("\t\t\nEnter error\n");
                break;
        }
    }
    return 0;
}
void deal_ctrl_c(int sig)
{
    deal(TRUE);
}
