#ifndef _LOGIN_H_
#define _LOGIN_H_

extern void regist(void);
/*extern int contrast_regist(struct user *regist);*/
extern void logining(void);
extern int  init(void);

struct user {
		char name[20];
		char password[30];	
};

#endif
