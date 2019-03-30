#ifndef _GAMELIST_H_
#define _GAMELIST_H_

extern void guess_list(void);
/*extern struct game_list_score *crazy_list_sequency(struct game_list_score *conduit1,
				                             int count);*/
extern void crazy_list(void);
/*extern struct game_list_score *guess_lsit_sequency(struct game_list_score *conduit1,
				                              int count);*/
extern void crazy_reset(void);
extern void guess_reset(void);

 struct game_list_score{
		char name[30];
		int guess_score;
		int crazy_score;
		struct game_list_score *next;
};

#endif
