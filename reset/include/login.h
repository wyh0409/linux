#ifndef _LOGIN_H_
#define _LOGIN_H_

extern int regist(void);
extern int logining(void);
extern int  init(void);

#define TRUE (1)
#define FALSE (0)
#define FILE_ERROR (-1)

struct user {
		char name[20];
		char password[30];	
};

#endif
