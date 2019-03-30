#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

#include "gamelist.h"
#include "game.h"


static struct game_list_score *crazy_list_sequency(struct game_list_score *conduitfist, int count);
static struct game_list_score *guess_list_sequency(struct game_list_score *conduitfist, int count);


/*
 * 疯狂按键游戏
 * 按键次数排序
 *              */

static struct game_list_score *crazy_list_sequency(struct game_list_score *conduitfist, int count)
{

	struct game_list_score *conduit, *conduit_second, *conduit3;

	conduit = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    
	while (conduit->next != NULL) {

        conduit = conduitfist;
        conduit_second = conduitfist->next;

        while (conduit_second->next != NULL) {

            if (conduit_second->crazy_score > (conduit_second->next)->crazy_score) {
                conduit3 = conduit_second->next;
                conduit->next = conduit_second->next;
                conduit_second->next = conduit_second->next->next;
                conduit->next->next = conduit_second;
                conduit_second = conduit3;
            }

            conduit_second = conduit_second->next;
            conduit = conduit->next;
		}
	}

	free(conduit);

	return(conduitfist);
}



/*
 * 疯狂按键游戏
 * 排行榜功能
 *               */

void crazy_list(void)
{

	int count = 0;
    int number = 1;
    int rt;
	struct game_list_score *head = NULL;
	struct game_list_score *conduitfist = NULL;
	struct game_list_score *conduit_second; 
	FILE *fp = NULL;

	fp = fopen("./lib/crazy_list.txt", "r");
	if (!fp) {
			crazy_reset();/*重置排行榜*/
	} else {
		head = (struct game_list_score *)malloc(sizeof(struct game_list_score));
		conduitfist = (struct game_list_score *)malloc(sizeof(struct game_list_score));
		conduit_second = (struct game_list_score *)malloc(sizeof(struct game_list_score));

		head->next = NULL;
		conduitfist = head;
		conduitfist->next = NULL;

		while (!feof(fp)) {
				
            rt = fread(conduit_second, sizeof(struct game_list_score),1,fp);
            if (rt == 0) {
                printf("Read error");
            }
            count = count+1;

            conduitfist->next = conduit_second;
            conduitfist = conduit_second;
            conduitfist->next = NULL;
		}
		fclose(fp);

		conduitfist = crazy_list_sequency(conduitfist, count);

		fp = fopen("./lib/crazy_list.txt", "w");

		while (head != NULL) {

            printf("RANK\t\t\tNumber\n");
            printf("%d\t\t\t%d\n",number,conduitfist->crazy_score);

            number = number+1;
            count = count-1;

            fwrite(head, sizeof(struct game_list_score),1,fp);

            head = head->next;
		}

        fflush(fp);
        fclose(fp);
				
	}

	free(head);
/*	free(conduitfist);*/
}


/*
 * 猜数字游戏
 * 排序
 *          */

static struct game_list_score *guess_list_sequency(struct game_list_score *conduitfist, int count)
{

	struct game_list_score *conduit = NULL, *conduit_second = NULL, *conduit3;

	conduit = (struct game_list_score *)malloc(sizeof(struct game_list_score));

	while (conduit->next != NULL) {

        conduit = conduitfist;
        conduit_second = conduitfist->next;

        while (conduit_second->next != NULL) {

            if (conduit_second->guess_score > (conduit_second->next)->guess_score) {
                conduit3 = conduit_second->next;
                conduit->next = conduit_second->next;
                conduit_second->next = conduit_second->next->next;
                conduit->next->next = conduit_second;
                conduit_second = conduit3;
			}

            conduit_second = conduit_second->next;
            conduit = conduit->next;
		}
	}

	free(conduit);
	return(conduitfist);
}

/*
 * 猜数字游戏
 * 游戏排行榜功能
 *                */

void guess_list(void)
{

	FILE *fp = NULL;
    int rt;
    int number = 1;
	struct game_list_score *head = NULL;
	struct game_list_score *conduitfist = NULL;
	struct game_list_score *conduit_second = NULL;
	int count = 0;

	fp = fopen("./lib/guess_list.txt","r");
	if (!fp) {
       guess_reset();
	} else {
       head = (struct game_list_score *)malloc(sizeof(struct game_list_score));
       conduitfist = (struct game_list_score *)malloc(sizeof(struct game_list_score));

       head->next = NULL;
       conduitfist = head;
       conduitfist->next = NULL;

       while (!feof(fp)) {
           conduit_second = (struct game_list_score *)malloc(sizeof(struct game_list_score));
            rt = fread(conduit_second, sizeof(struct game_list_score),1,fp);
            if (rt == 0) {
                printf("Read error");
            }
            conduitfist->next = conduit_second;
            conduitfist = conduit_second;
            conduitfist->next = NULL;

            count = count+1;
       }

       fclose(fp);

       conduitfist = guess_list_sequency(conduitfist, count);
				
       fp = fopen("./lib/guess_list.txt", "w");

       while (conduitfist != NULL) {
            printf("RANK\t\t\tNumber\n");
            printf("%d\t\t\t%d\n",number,conduitfist->guess_score);
            number = number+1;

            fwrite(conduitfist,sizeof(struct game_list_score),1,fp);

            conduitfist = conduitfist->next;
						
            count = count-1;
       }
       fflush(fp);
       fclose(fp);
	}

    free(head);
    free(conduitfist);
	free(conduit_second);
}


/*
 * 疯狂按键
 * 排行榜文件重置
 *              */
void crazy_reset(void)
{

	FILE *fp = NULL;

	fp = fopen("./lib/crazy_list.txt","w");

	fclose(fp);
}


/*
 * 猜数字游戏
 * 排行榜文件重置
 *                 */
void guess_reset(void)
{

	FILE *fp = NULL;

	fp = fopen("./lib/guess_list.txt","w");

	fclose(fp);
}
