#ifndef _GAMELIST_H_
#define _GAMELIST_H_

extern int guess_list(void);
extern int crazy_list(void);
extern void crazy_reset(void);
extern void guess_reset(void);

#define TRUE        		(1)
#define OPEN_FILE_FLASE 	(-1)
#define FILE_ERROR 			(-1)
#define FILE_NULL 			(0)

 struct game_list_score{
		char name[30];
		int guess_score;
		int crazy_score;
		struct game_list_score *next;
};

#endif
