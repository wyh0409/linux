#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "choose.h"
#include "game.h"
#include "color.h"
#include "gamelist.h"
#include "show.h"


/*
 * 整合游戏内部选择界面
 * 以及打印和选择
 */

int game_choose(int count1)
{

	char direction;
	int count = 0;
	int run = 1;
	char ch;

	count1 = 0;
	
	while ((ch = getchar()) != '\n' && ch != EOF);

    system("stty -echo");
    system("stty -icanon");

	game_choose_ui(count);

	while (run) {

			direction = getchar();
				
			switch (direction) {
					case 'w':
						if (count1 == 0){
							break;
                        } else {
							count = count1;	
							count = count-1;
							count1 = count;
							choose_game2(count);
                            break;
						}
				
					case 's':
						if (count1 == 4) {
							break;
                        } else {
							count = count1;
							count = count+1;
							count1 = count;
							choose_game2(count);
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

	return(count1);
	
}

/*
 * 打印游戏内的选择界面
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
			,choose[count]);
	printf("            %c 2.Game rule                           \n"
			,choose[count+1]);
	printf("            %c 3.Game ling                           \n"
			,choose[count+2]);
	printf("            %c 4.Back                                \n"
			,choose[count+3]);
	printf("            %c 5.Quit                                \n"
			,choose[count+4]);
	printf("=======================================================\n");
	printf("Use 'w' to up 's' to down\n");
	printf(NONE);
		
	return 0;
}

/*
 * 猜数字游戏功能选择
 */

void guess_choose(void)
{

	int jump = 1;
	int count;
	int count1 = 0;

	while (jump) {

			system("clear");
		
			printf("\n           Welcome guess game              \n");

			count = game_choose(count1);

			switch (count) {
				case 0:
					guess_enter_number();
					break;

				case 1:
					show_Guess_Rule();
                    getchar();
					break;

				case 2:
					guess_list();
                    getchar();
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
 * 疯狂按键游戏功能选择选择
 */

void crazy_choose(void)
{

	int jump = 1;
	int count;
	int count1 = 0;

	while (jump) {

			system("clear");

			printf("\n          Welcome crazy game               \n");

			count =  game_choose(count1);

			switch (count) {
				case 0:
					crazy_enter();
					break;

				case 1:
					Crazy_Rule();
                    getchar();
					break;

				case 2:
					crazy_list();
                    getchar();
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
 * 游戏选择界面打印的选择
 */

int choose_game2(int count)
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
            printf("hapen error");

	}

    return 0;

}

