#include <stdio.h>
#include <stdlib.h>

#include "color.h"
#include "show.h"


/*
 * @brief 注册或登录界面
 *                */
void login_ui(void)
{
	printf(YELLOW);
	printf("\n");
	printf("========================================================\n"
           "|                     Game login or regist             |\n"
           "|                     1:regist                         |\n"
           "|                     2:login                          |\n"
           "|                     3:quit                           |\n"
           "|======================================================|\n");
	printf(NONE);
}

/*
 *@brief  猜数字游戏规则
 *                  */
void show_guess_rule(void)
{
	printf(RED);
	printf("\n");
	printf("=========================================================\n"
           "*                      游戏规则                         *\n"
           "*      随机一个四位数字由玩家猜，每猜一次给予玩家提示   *\n"
           "*      提示：A前面的数字代表数字和位置都正确            *\n"
           "*            B前面的数字代表数字正确而位置不对的数      *\n"
           "*            当玩家取得4A0B时获得游戏胜利               *\n"
           "=========================================================");
	printf(NONE);
}

/*
 *@brief  疯狂按键游戏规则
 * */
void crazy_rule(void)
{
	printf(RED);
	printf("\n");
	printf("=========================================================\n"
           "*                    游戏规则                           *\n"
			"*       在规定的5秒内疯狂按键盘上的一次s再按一次回车键  *\n"
			"*          5秒内按键的总次数越高排行榜越高              *\n"
			"=========================================================");
		printf(NONE);

}


/**
 * @brief	游戏选择界面  
 */
void choose_game(void)
{
	printf(YELLOW);
	printf("\n");
	printf("---------------------------------------------------------\n"
           "|                 Game Choose                           |\n"
           "|                 1:Guess Game                          |\n"
           "|                 2:Crazy Game                          |\n"
           "|                 3:Back                                |\n"
           "---------------------------------------------------------\n");
	printf(NONE);
}


