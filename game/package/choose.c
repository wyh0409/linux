#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "choose.h"
#include "game.h"
#include "color.h"
#include "game_list.h"
#include "show.h"


/**
 * @brief	光标上下移动	
 * @param	整合游戏内部选择界面以及打印和选择
 * @return	返回选择功能对应的值
 */
int game_choose(int choose_count)
{
	char direction;
	int count = 0;
	int run = 1;
	char char_empty;

	choose_count = 0;
	
	while ((char_empty = getchar()) != '\n' && char_empty != EOF);

    system("stty -echo");
    system("stty -icanon");

	game_choose_ui(count);

	while (run) {
		direction = getchar();
			
		switch (direction) {
			case 'w':
				if (choose_count == 0) {
					break;
				} else {
					count = choose_count;	
					count = count-1;
					choose_count = count;
					choose_game_log(count);
					break;
				}
		
			case 's':
				if (choose_count == 4) {
					break;
				} else {
					count = choose_count;
					count = count+1;
					choose_count = count;
					choose_game_log(count);
					break;   
				}

			case '\n':
				run = 0;
				break;

			default:
				printf("enter error");		
		}
	}

	system("stty icanon");
	system("stty echo");

	return(choose_count);
	
}

/*
 * @brief		打印游戏内的选择界面
 * @return		成功返回0
 */
int game_choose_ui(int count)
{
	char choose[25] = {'*', ' ', ' ', ' ', ' ',
					   ' ', '*', ' ', ' ', ' ',
					   ' ', ' ', '*', ' ', ' ',
					   ' ', ' ', ' ', '*', ' ',
					   ' ', ' ', ' ', ' ', '*'};


	printf(YELLOW);
	printf("=====================================================\n");
	printf("            %c 1.Start game                          \n"
			, choose[count]);
	printf("            %c 2.Game rule                           \n"
			, choose[count+1]);
	printf("            %c 3.Game ling                           \n"
			, choose[count+2]);
	printf("            %c 4.Back                                \n"
			, choose[count+3]);
	printf("            %c 5.Quit                                \n"
			, choose[count+4]);
	printf("=======================================================\n");
	printf("Use 'w' to up 's' to down\n");
	printf(NONE);
		
	return 0;
}

/*
 * @brief	猜数字游戏功能选择
 */
void guess_choose(void)
{
	int jump = 1;
	int count;
	int choose_count = 0;
	char char_empty;

	while (jump) {
		system("clear");		
		printf("\n           Welcome guess game              \n");

		count = game_choose(choose_count);

		switch (count) {
			case 0:
				guess_enter_number();
				break;

			case 1:
				show_guess_rule();
				getchar();
				break;

			case 2:
				guess_list();
				while ((char_empty = getchar()) != '\n' && char_empty != EOF);
				break;

			case 3:
				jump = 0;
				break;

			case 4:
				exit(0);
				break;

			default:
				printf("Enter error\n");
		}	
	}
}

/*
 * @brief	疯狂按键游戏功能选择选择
 */
void crazy_choose(void)
{
	int jump = 1;
	int count;
	int choose_count = 0;
	char char_empty;

	while (jump) {
		system("clear");
		printf("\n          Welcome crazy game               \n");

		count =  game_choose(choose_count);

		switch (count) {
			case 0:
				crazy_enter();
				break;

			case 1:
				crazy_rule();
				getchar();
				break;

			case 2:
				crazy_list();
				while ((char_empty = getchar()) != '\n' && char_empty != EOF);
				break;

			case 3:
				jump = 0;
				break;

			case 4:
				exit(0);
				break;
		}	
	}
}

/*
 * @brief	游戏选择界面打印的选择
 * @return	成功返回0
 */
int choose_game_log(int count)
{
	switch (count) {
		case 0: 
            count = 0;
            system("clear");
            game_choose_ui(count);
            break;

		case 1: 
            count = 5;
            system("clear");
            game_choose_ui(count);
            break;

		case 2: 
            count = 10;
            system("clear");
            game_choose_ui(count);
            break;

		case 3: 
            count = 15;
            system("clear");
            game_choose_ui(count);
            break;

		case 4: 
            count = 20;
            system("clear");
            game_choose_ui(count);
            break;

		default :
            printf("happen error");

	}

    return 0;

}

