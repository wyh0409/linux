#ifndef _GAME_H_
#define _GAME_H_

extern int guess_random_number(int dismantle_create_number[4]);
extern void guess_enter_number(void);
extern int contrast_number(int run1, int create_number[4], int guess_number[4]);
extern void crazy_enter(void);

struct game_list_score2{
		char name[30];
		int guess_score;
		int crazy_score;
};

#endif

