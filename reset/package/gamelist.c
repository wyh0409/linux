#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>

#include "gamelist.h"
#include "game.h"
#include "debug.h"

static struct game_list_score *crazy_list_sequency(struct game_list_score *conduitfist, int count);
static struct game_list_score *guess_list_sequency(struct game_list_score *conduitfist, int count);


/*
 * 疯狂按键游戏
 * 按键次数排序
 *              */

static struct game_list_score *crazy_list_sequency(struct game_list_score *conduitfist, int count)
{
    int temp;
	struct game_list_score *conduit, *conduit_crazy;

	conduit = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    conduit_crazy = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    if (conduit == NULL) {
        DEBUG("conduit malloc flase");
    }
    if (conduit_crazy == NULL) {
        DEBUG("conduit_crazy malloc flase");
    }
    
    
    conduit = conduitfist;
    conduit_crazy = NULL;
    
	while (conduit != conduit_crazy) {
        while (conduit->next != NULL) {

            if (conduit->crazy_score < (conduit->next)->crazy_score) {
                temp = conduit->crazy_score;
                conduit->crazy_score = conduit->next->crazy_score;
                conduit->next->crazy_score = temp;

            }
            conduit = conduit->next;
		}
        conduit_crazy = conduit;
        conduit = conduitfist;
	}

	//free(conduit);
    free(conduit_crazy);
	return(conduitfist);
}



/*
 * 疯狂按键游戏
 * 排行榜功能
 *               */

int crazy_list(void)
{
	int count;
    int number = TRUE;
    int rt = TRUE;
    int fd;
	struct game_list_score *head = NULL;
	struct game_list_score *conduitfist = NULL;
	struct game_list_score *conduit_second; 

	fd = open("./lib/crazy_list.txt",O_RDWR,0777);
	if (fd == OPEN_FILE_FLASE) {
        DEBUG("open crazy_list fail");
        close(fd);
		crazy_reset();/*重置排行榜*/
	}
    head = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    conduitfist = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    conduit_second = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    if (head == NULL) {
        DEBUG("head malloc flase");
    }
    if (conduitfist == NULL) {
        DEBUG("conduitfis malloc flase");
    }
    if (conduit_second == NULL) {
        DEBUG("conduig_second malloc flase");
    }
    
    
    head->next = NULL;
    conduitfist = head;
    while (rt == TRUE) {
        rt = read(fd,conduit_second,sizeof(struct game_list_score)); 
        if (rt == FILE_ERROR) {
            DEBUG("Read error");
        }
        if (rt > FILE_NULL) {
            conduit_second->next = NULL;
            if (NULL == head) {
                head = conduit_second;
            } else {
                conduitfist->next = conduit_second;
                conduitfist = conduit_second;
            }   
        }  
        count = count+1;
    }
    close(fd);

    conduitfist = crazy_list_sequency(conduitfist, count);
    fd = open("./lib/crazy_list.txt",O_RDWR,0777);
    if (fd == OPEN_FILE_FLASE) {
        DEBUG("open crazy_list.txt flase");
        return OPEN_FILE_FLASE;
    }
    

    while (head != NULL) {
        printf("RANK\t\t\tNumber\n");
        printf("%d\t\t\t%d\n",number,head->crazy_score);

        number = number+1;
        count = count-1;

        rt = write(fd,head,sizeof(struct game_list_score));
        if (rt == FILE_ERROR) {
            DEBUG("Write error");
        }
        
        head = head->next;
    }
    close(fd);				
	//free(conduitfist);
    return TRUE;
}


/*
 * 猜数字游戏
 * 排序
 *          */

static struct game_list_score *guess_list_sequency(struct game_list_score *conduitfist, int count)
{

	struct game_list_score *conduit = NULL, *conduit_second = NULL, *conduit3;

	conduit = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    if (conduit == NULL) {
        DEBUG("guess conduit malloc flase");
    }
    

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

int guess_list(void)
{
    int rt = TRUE;
    int number = 1;
    int fd;
	struct game_list_score *head = NULL;
	struct game_list_score *conduitfist = NULL;
	struct game_list_score *conduit_second = NULL;
	int count = 0;

	fd = open("./lib/guess_list.txt",O_RDWR,0777);
	if (fd == FILE_ERROR) {
       guess_reset();
    }
    close(fd);

    head = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    conduitfist = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    if (head == NULL) {
        DEBUG("guess head malloc flase");
    }
    if (conduitfist == NULL) {
        DEBUG("guess conduitfist malloc flase");
    }
    
    

    if (NULL != head) {
        head->next = NULL;
    }
    conduitfist = head;
    conduitfist->next = NULL;

    fd = open("./lib/guess_list.txt",O_RDWR,0777);
    while (rt == TRUE) {
        conduit_second = (struct game_list_score *)malloc(sizeof(struct game_list_score));
        if (conduitfist == NULL) {
            DEBUG("guess conduit_second malloc flase");
        }
        rt = read(fd,conduit_second,sizeof(struct game_list_score));
        if (rt == FILE_ERROR) {
            DEBUG("Read error");
        }
        if (rt > FILE_NULL) {
            conduit_second->next = NULL;
            if (NULL == head) {
                head = conduit_second;
            } else {
                conduitfist->next = conduit_second;
                conduitfist = conduit_second;
            }   
        }  
        count = count+1;
    }
    close(fd);

    head = guess_list_sequency(head, count);
            
    fd = open("./lib/guess_list.txt",O_RDWR,0777);
    if (fd == OPEN_FILE_FLASE) {
        DEBUG("open guess_list.txt flase");
        fd = open("./lib/guess_list.txt",O_RDWR,0777);
        if (fd == OPEN_FILE_FLASE) {
            return FILE_ERROR;
        }
        
    }
    

    while (!head) {
        printf("RANK\t\t\tNumber\n");
        printf("%d\t\t\t%d\n",number,head->guess_score);
        number = number+1;

        rt = write(fd,head,sizeof(struct game_list_score));
        if (rt == FILE_ERROR) {
            DEBUG("write error");
        }
        
        head = head->next;
                    
        count = count-1;
    }
    close(fd);

    free(head);
    free(conduit_second);

    return TRUE;
}


/*
 * 疯狂按键
 * 排行榜文件重置
 *              */
void crazy_reset(void)
{
    int fd;
	fd = open("./lib/crazy_list.txt",O_RDWR|O_CREAT,0777);
    if (fd == OPEN_FILE_FLASE) {
        DEBUG("create crazy_list.txt flase");
    }
    

	close(fd);
}


/*
 * 猜数字游戏
 * 排行榜文件重置
 *                 */
void guess_reset(void)
{
    int fd;
	fd = open("./lib/guess_list.txt",O_RDWR|O_CREAT,0777);
    if (fd == OPEN_FILE_FLASE) {
        DEBUG("create guess_list.txt flase");
    }
    

	close(fd);
}
