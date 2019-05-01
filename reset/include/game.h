#ifndef _GAME_H_
#define _GAME_H_

extern int guess_random_number(int dismantle_create_number[4]);
extern int guess_enter_number(void);
extern int contrast_number(int run1, int create_number[4], int guess_number[4]);
extern int crazy_enter(void);
extern void deal(int verdict);

#define TRUE (1)
#define FALSE (0)
#define Digital_digits (4)

struct game_list_score2{
		char name[30];
		int guess_score;
		int crazy_score;
};

#endif

