#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <signal.h>
#include <stdint.h>
#include <fcntl.h>
#include <sys/time.h>
#include <termios.h>


#include "game.h"
#include "color.h"
#include "gamelist.h"
#include "debug.h"



static void handler(int sig);
static struct itimerval oldtv;
static struct itimerval itv;
static void set_timer(void);
static void uninit_time(void);
static int count = 0;

/*
 * 生成随机数字
 * 将生成的数字拆分
 *                 */
int guess_random_number(int dismantle_create_number[4])
{
	int create_number;

	do {
       srand((int)time(NULL));

       create_number = rand()%(9000)+1000;
				
       dismantle_create_number[0] = create_number/1000;
       dismantle_create_number[1] = (create_number%1000)/100;
       dismantle_create_number[2] = (create_number%100)/10;
       dismantle_create_number[3] = create_number%10;

    } while (dismantle_create_number[0] == dismantle_create_number[1]
            || dismantle_create_number[0] == dismantle_create_number[2]
            || dismantle_create_number[0] == dismantle_create_number[3]
            || dismantle_create_number[1] == dismantle_create_number[2]
            || dismantle_create_number[1] == dismantle_create_number[3]
            || dismantle_create_number[2] == dismantle_create_number[3]);

		
    return(dismantle_create_number[4]);
}


/*
 * 猜数字游戏输入
 * 将输入的数字拆分
 *                  */
int guess_enter_number(void)
{
	int guess_enter;
	int count = 1;
	int run1 = 1;
    char ch;
	int dismantle_guess_number[4];
	int dismantle_create_number[4];

	struct game_list_score2 *guess_time;
	FILE *fp = NULL;

	dismantle_create_number[4] = guess_random_number(dismantle_create_number);

	while (run1) {
        printf(RED"\nPlease enter your guess number:\n"NONE);
        scanf("%d" ,&guess_enter);
        while((ch = getchar()) != '\n' && ch != EOF);
        
        if ((guess_enter/1000) == 0 || (guess_enter/1000) >= 10) {
            printf("Enter Error,please resume load");
        } else {
            dismantle_guess_number[0] = guess_enter/1000;
            dismantle_guess_number[1] = (guess_enter%1000)/100;
            dismantle_guess_number[2] = (guess_enter%100)/10;
            dismantle_guess_number[3] = guess_enter%10;

            guess_time = malloc(sizeof(struct game_list_score));

            run1 = contrast_number(run1, dismantle_create_number
                                    ,dismantle_guess_number);
            guess_time->guess_score = count+1;
        }
	}

	fp = fopen("./lib/guess_list.txt","a+");
    if (!fp) {
        fp = fopen("./lib/guess_list.txt", "a+"); 
        if (!fp) {
            DEBUG("open guess_lsit.txt flase");
            return GUESS_FILE_ERROR;
        }
    }
	fwrite(guess_time, sizeof(struct game_list_score), 1, fp);
	fflush(fp);
	fclose(fp);
    return TRUE;
}

/*
 * 对比输入数字和生成数字
 * 生成对比结果
 */
int contrast_number(int run1, int create_number[4], int guess_number[4])
{
    int run;
	int count;
	int count1 = 0;
	int count2 = 0;
    char choose;
    char ch;

	for (count = 0; count < Digital_digits; count++) {
		if (create_number[count]== guess_number[count]) {
           count1 = count1+1;
           continue;
		}

        if (guess_number[count] == create_number[0]
           || guess_number[count] == create_number[1]
           || guess_number[count] == create_number[2]
           || guess_number[count] == create_number[3]) {
           count2 = count2+1;
		} else {
             count1 = count1;
             count2 = count2;
		}
			
	}

	if (count1 == Digital_digits) {
        printf("%dA%dB\n",count1,count2);
        printf("You win!!\n");
        run = FALSE;
	} else {
        printf("%dA%dB\n",count1,count2);
        run = TRUE;
	}

    while (run1) {
        printf("Enter any to contiue");
        while((ch = getchar()) != '\n' && ch != EOF);
        printf("\nEnter 'r' play game again,  'q' quit game \n"
                       "'b' back game choose, 'c' continue\n");       
	    choose = getchar();

        switch (choose) {
            case 'r':
                run1 = TRUE;
                break;

            case 'b':
                run1 = FALSE;
                run = FALSE;
                break;

            case 'q':
                exit(0);
                break;

            case 'c':
                run1 = FALSE;
                break;

            default: 
                printf("\nEnter error\n");
        }
    }
    return(run);
}




/*
 * 时间倒计时
 *           */
static void handler(int sig){
		
	count = count+1;

}


/*
 * 疯狂按键游戏
 * 游戏输入、
 * */
int crazy_enter(void)
{
	   
	char crazy_enter;
	int total_number = 0;;
	struct game_list_score *crazy_number;
	unsigned int alarm(unsigned int seconds);
	char ch;
    //int rt;
	FILE *fp = NULL;
    struct sigevent evp;

    count = 0;
    memset(&evp, 0, sizeof(struct sigevent));

	crazy_number = (struct game_list_score *)malloc(sizeof(struct game_list_score));

    printf("Enter ‘enter’ to continue");
    while((ch = getchar()) != '\n' && ch != EOF);

	printf("PLEASE CRAZY ENTER S ONCE PRESS ENTER ONCE\n");

	signal(SIGALRM, handler);
	set_timer();


	system("stty -icanon");
	system("stty -echo");

	while (count < 5) {

          signal(SIGALRM, handler);
          crazy_enter = getchar();
          crazy_number->crazy_score = crazy_number->crazy_score+1;
          total_number = total_number+1;
				
	}

    uninit_time();
	printf("%c",crazy_enter);
	printf("YOU CRAZY ENTER %d NUMBER",total_number);

	system("stty icanon");
	system("stty echo");

	fp = fopen("./lib/crazy_list.txt", "a+");
    if (!fp) {
        fp = fopen("./lib/crazy_list.txt", "a+"); 
        if (!fp) {
            DEBUG("open crazy_lsit.txt flase");
            return CRAZY_FILE_ERROR;
        }
    }
    
	fwrite(&crazy_number, sizeof(struct game_list_score),1,fp);

    fflush(fp);
	fclose(fp);
    free(crazy_number);

    return TRUE;
}

/*
 * 定时器
 *         */
void set_timer(void)
{
		
	itv.it_interval.tv_sec = 1;
	itv.it_interval.tv_usec = 0;
	itv.it_value.tv_sec = 1;
	itv.it_value.tv_usec = 0;
	setitimer(ITIMER_REAL, &itv, &oldtv);
}

void uninit_time(void) 
{
    struct itimerval value;
    value.it_value.tv_sec = 0;
    value.it_value.tv_usec = 0;
    value.it_interval = value.it_value;
    setitimer(ITIMER_REAL, &value, NULL);
}

void deal(int verdict)
{
    char choose;
    if (verdict == TRUE) {
        printf("\nI konw this was dangerous, if you using printf.\n"
               "I think this should be something, don't worry\n"
               "next I could deal or more terrible\n"
               "now if you want quit enter 'y', continue enter 'n'\n");
        choose = getchar();
        if (choose == 'y') {
            exit(0);
        } else if (choose == 'n') {
            printf("because code not well, you could befor use\n");    
        } else {
            printf("your too boring quit\n");
            exit(0);
        }       
    }
}