#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>

#include "game_list.h"
#include "game.h"
#include "debug.h"

static struct game_list_score *crazy_list_sequency(struct game_list_score *conduitfist, int count);
static struct game_list_score *guess_list_sequency(struct game_list_score *conduitfist, int count);

/**
 * @brief   次数排序
 * @param   疯狂按键游戏按键次数排序
 * @return: 返回排序后的值
 */
static struct game_list_score *crazy_list_sequency(struct game_list_score *conduitfist, int count)
{
    int temp;
	struct game_list_score *conduit = NULL, *conduit_crazy = NULL;

	conduit = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    conduit_crazy = (struct game_list_score *)malloc(sizeof(struct game_list_score));

    if (!conduit) {
        DEBUG("conduit malloc FALSE ");
    }
    if (!conduit_crazy) {
        DEBUG("conduit_crazy malloc FALSE ");
    }
    
    /*链表排序*/
    conduit = conduitfist;
    for(conduit = conduitfist; conduit != NULL; conduit = conduit->next) {
        for(conduit_crazy = conduit->next; conduit_crazy != NULL; conduit_crazy = conduit_crazy->next) {
            if (conduit->crazy_score < conduit_crazy->crazy_score) {
                temp = conduit->crazy_score;
                conduit->crazy_score = conduit_crazy->crazy_score;
                conduit_crazy->crazy_score = temp;

            }
        }     
    }

        
	free(conduit);
    free(conduit_crazy);
    conduit = NULL;
    conduit_crazy = NULL;

	return(conduitfist);
}

/**
 * @brief   排行榜功能
 * @param   疯狂按键排行榜
 * @return  成功返回1
 *          失败返回-1
 */
int crazy_list(void)
{
	int count;
    int number = TRUE;
    int return_value = TRUE;
    int file_value;
    struct game_list_score *crazy_head = NULL;
    struct game_list_score *crazy_node = NULL;
    struct game_list_score *crazy_end = NULL;
    struct game_list_score *scan_list;

	file_value = open("./lib/crazy_list.txt", O_RDWR, 0777);
    lseek(file_value, 0, SEEK_SET);
	if (file_value == OPEN_FILE_FALSE) {
        DEBUG("open crazy_list fail");
        close(file_value);
		crazy_reset();/*重置排行榜*/
	}
    crazy_head = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    if (!crazy_head) {
        DEBUG("head malloc false");
    }

    /*创建链表*/
   crazy_end = crazy_head;
    while (return_value > FILE_NULL) {
        crazy_node = (struct game_list_score *)malloc(sizeof(struct game_list_score)); 
        return_value = read(file_value, crazy_node, sizeof(struct game_list_score));
        DEBUG("%d",crazy_node->crazy_score);
        if (return_value == FILE_ERROR) {
            DEBUG("Read error");
        }
            crazy_end->next = crazy_node;
            crazy_end = crazy_node;
 
        if (return_value == FILE_NULL) {
            crazy_end->next = NULL;  
        }
        count = count+1;
    }
    close(file_value);

    crazy_head = crazy_list_sequency(crazy_head, count);
    file_value = open("./lib/crazy_list.txt", O_RDWR, 0777);
    if (file_value == OPEN_FILE_FALSE ) {
        DEBUG("open crazy_list.txt FALSE ");
        return OPEN_FILE_FALSE ;
    }
    
    while (crazy_head->next != NULL) {
        printf("RANK\t\t\tNumber\n");
        printf("%d\t\t\t%d\n", number, crazy_head->crazy_score);

        number = number+1;
        count = count-1;     
        crazy_head = crazy_head->next;
    }
    close(file_value);

    /*释放链表*/
    scan_list = crazy_head;
    while(scan_list != NULL){
        free(scan_list);
		scan_list = scan_list->next;
    }   
    return TRUE;
}


/**
 * @brief   次数排序
 * @param   猜数字游戏按键次数排序
 * @return: 返回排序后的值
 */
static struct game_list_score *guess_list_sequency(struct game_list_score *conduitfist, int count)
{
	struct game_list_score *guess_conduit = NULL, *conduit_second = NULL;
    int temp = FALSE;

	guess_conduit = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    conduit_second = (struct game_list_score *)malloc(sizeof(struct game_list_score));
    if (!guess_conduit) {
        DEBUG("guess guess_conduit malloc FALSE ");
    }
    if (!conduit_second) {
        DEBUG("conduit_second malloc False");
    }

    /*链表排序*/
    guess_conduit = conduitfist;
    for(guess_conduit = conduitfist; guess_conduit != NULL; guess_conduit = guess_conduit->next) {
        for(conduit_second = guess_conduit->next; conduit_second != NULL; conduit_second = conduit_second->next) {
            if (guess_conduit->crazy_score < conduit_second->crazy_score) {
                temp = guess_conduit->crazy_score;
                guess_conduit->crazy_score = conduit_second->crazy_score;
                conduit_second->crazy_score = temp;

            }
        }     
    }

	free(guess_conduit);
    guess_conduit = NULL;
    free(conduit_second);
    conduit_second = NULL;

	return(conduitfist);
}

/**
 * @brief   排行榜功能
 * @param   猜数字排行榜
 * @return  成功返回1
 *          失败返回-1
 */
int guess_list(void)
{
    int return_value = TRUE;
    int number = 1;
    int file_value;
	struct game_list_score *guess_head = NULL;
	struct game_list_score *guess_node = NULL;
	struct game_list_score *guess_end = NULL;
    struct game_list_score *scan_list;  
	int count = 0;

	file_value = open("./lib/guess_list.txt", O_RDWR, 0777);
	if (file_value == FILE_ERROR) {
       guess_reset();
    }
    close(file_value);

    guess_head = (struct game_list_score *)malloc(sizeof(struct game_list_score));

    if (NULL == guess_head) {
        DEBUG("guess guess_head malloc FALSE ");
    }
    
    /*创建链表*/
    guess_end = guess_head;
    while (return_value > FILE_NULL) {
        guess_node = (struct game_list_score *)malloc(sizeof(struct game_list_score)); 
        return_value = read(file_value, guess_node, sizeof(struct game_list_score));
        DEBUG("%d",guess_node->guess_score);
        if (return_value == FILE_ERROR) {
            DEBUG("Read error");
        }
        guess_end->next = guess_node;
        guess_end = guess_node;

        if (return_value == FILE_NULL) {
            guess_end->next = NULL;  
        }
        count = count+1;
    }
    close(file_value);

    guess_head = guess_list_sequency(guess_head, count);
            
    file_value = open("./lib/guess_list.txt", O_RDWR, 0777);
    if (file_value == OPEN_FILE_FALSE ) {
        DEBUG("open guess_list.txt FALSE ");
        return OPEN_FILE_FALSE ;
    } 
    while (guess_head->next != NULL) {
        printf("RANK\t\t\tNumber\n");
        printf("%d\t\t\t%d\n", number, guess_head->guess_score);
        number = number+1;
        count = count-1;     
        guess_head = guess_head->next;
    }
    close(file_value);

    /*释放链表*/
    scan_list = guess_head;
    while(scan_list != NULL){
        free(scan_list);
		scan_list = scan_list->next;
    }   

    return TRUE;
}


/*
 * @brief   疯狂按键排行榜文件重置
 *              */
void crazy_reset(void)
{
    int file_value;
	file_value = open("./lib/crazy_list.txt", O_RDWR|O_CREAT, 0777);
    if (file_value == OPEN_FILE_FALSE ) {
        DEBUG("create crazy_list.txt FALSE ");
    }
    

	close(file_value);
}


/*
 * @brief   猜数字游戏排行榜文件重置
 *                 */
void guess_reset(void)
{
    int file_value;
	file_value = open("./lib/guess_list.txt", O_RDWR|O_CREAT, 0777);
    if (file_value == OPEN_FILE_FALSE ) {
        DEBUG("create guess_list.txt FALSE ");
    }
    

	close(file_value);
}
