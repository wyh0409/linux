#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <ctype.h>

#include "login.h"
#include "color.h"
#include "debug.h"

static int contrast_regist(char *name);


int regist(void)/*游戏注册*/
{
	int count1;
	int jump;
	struct user *regist,*player;
	FILE *fp = NULL;
	char ch;
    int rt = 0;

	regist = (struct user *)malloc(sizeof(struct user));
	player = (struct user *)malloc(sizeof(struct user));

	system("clear");

	printf("\n\n\t\t\tWelocm registration game\n\n");

	jump = TRUE;
	while (jump) {
        printf("\n\t\tPlease enter user name[no more than 10 charaters]:");
        scanf("%s",regist->name);
        
        if (strlen(regist->name) < 10) {
            fp = fopen("./lib/player.txt", "r");
            if (!fp) {
                DEBUG("\t\t\topen player faile\n\n");
                fp = fopen("./lib/player.txt", "w");
                if (!fp) {
                    rt = PLAYER_FILE_ERROR;
                }
                
            } else {
                fclose(fp);
                jump = contrast_regist(regist->name);
            }
        } else {
            printf("\n\t\tIncorrect account,plesde input again\n");
            jump = TRUE;
        }
    }

	jump = TRUE;
	while (jump) {
        printf("\n\t\tPlease enter password[password 8 character]:");

        system("stty -icanon");
        system("stty -echo");
        system("stty igncr");

        while ((ch = getchar()) != '\n' && ch != EOF);
        
        for (count1 = 0; count1 < 8; count1++) {
            regist->password[count1] = getchar();
            /*判断密码输入*/
            if (isalpha(regist->password[count1]) != 0
                || isdigit(regist->password[count1]) != 0) {

                printf("*");
            } else {
                count1 = count1-1;
                printf("\n\t\tenter error ");
            }
        }

        system("stty echo");
        system("stty icanon");
        system("stty -igncr");
        
        jump = 0;
	}

	fp = fopen("./lib/player.txt","a");
	if (!fp) {
        DEBUG("open error\n");
        fp = fopen("./lib/player.txt", "a");
        if (!fp) {
            rt = PLAYER_FILE_ERROR;
        }
        
	}
    
    fwrite(regist,sizeof(struct user),1,fp);
    fflush(fp);
    fclose(fp);

    free(regist);
    free(player);

    return (rt);
}

/*判断注册*/
static int contrast_regist(char *name)
{

    FILE *fp = NULL;
	struct user *player;
	int jump = 1;

	fp = fopen("./lib/player.txt", "r");
    rewind(fp);
    /*if (rt == FILE_ERROR) {
        printf("File errror");
    }*/
    
	player = (struct user *)malloc(sizeof(struct user));

	while (!feof(fp)) {
        fread(player,sizeof(struct user),1,fp);
        if (player->name == NULL) {
            jump = 0;
        } else {
            if (strcmp(player->name, name) == 0) {
                printf("\nYour account alread exists.plase re register\n");
                jump = 1;
                break;
            } else {
                jump = 0;
                break;
            }
        }
    }
	fclose(fp);
	free(player);

	return(jump);
}

/*登录*/
int logining(void)
{
	int run3 = 1;
	int count1;
	int count2 = 1;
    int rt = 0;
	char ch;
	struct user *login, *player;
	FILE *fp = NULL;

	login = (struct user *)malloc(sizeof(struct user));
	player = (struct user *)malloc(sizeof(struct user));

	system("clear");

	while (run3) {
          printf("\n\n\t\t\tWelcome login game\n\n");
          printf("\t\tenter user name:");
          scanf("%s", login->name);

          printf("\n\t\tenter your password:");
          system("stty -icanon");
          system("stty -echo");
          system("stty igncr");
          
          while ((ch = getchar()) != '\n' && ch != EOF);
          
          for (count1 = 0; count1 < 8; count1++) {
              login->password[count1] = getchar();
              /*判断密码输入*/
              if (isdigit(login->password[count1]) != 0
                 || isalpha(login->password[count1]) != 0) {
                  printf("*");
              } else {
                   count1 = count1-1;
                   printf("\n\t\tenter error");
              }
          }

          system("stty icanon");
          system("stty echo");
          system("stty -igncr");
          
          fp = fopen("./lib/player.txt", "r");
          if (!fp) {
              rt = PLAYER_FILE_ERROR;
          }
          
          rewind(fp);
          
          while (!feof(fp)) {
                fread(player,sizeof(struct user),1,fp);
                if(strcmp(player->name, login->name) == 0 &&
                   strcmp(player->password, login->password) == 0) {
                   printf("\n\n\t\tWelcome start game\n\n");
                   run3 = 0;
                   break;
                }	
          }
          fclose(fp);
          
          if (run3 == 1) {
              printf("\n\n\t\t Login error \n\n");
              count2 = count2+1;
          } else {
                  continue;
          }
       
          if (count2 > 3) {
              exit(0);
              break;
          }  else {
               continue;
          }
	}

	free(login);
	free(player);

    return rt;
}


int init(void)
{
    int fd;
  
    fd = open("./lib/player.txt", O_CREAT|O_RDWR, 0777);
    if (fd == FILE_ERROR) {
       if (access("./lib", F_OK) != 0) {
           mkdir("./lib", 0777);
           fd = open("./lib/player.txt", O_CREAT|O_RDWR, 0777);
           if (fd == FILE_ERROR) {
               printf("file create error");
               exit(0);
           }
           close(fd); 
        }
    } else {
        close(fd);
    }

    fd = open("./lib/guess_list.txt", O_CREAT|O_RDWR, 0777);
    if (fd == FILE_ERROR) {
        fd = open("./lib/guess_list.txt", O_CREAT|O_RDWR, 0777);
        if (fd == FILE_ERROR) {
            printf("guess_file create error");
               exit(0);
        }   
    } else {
        close(fd);
    }

    fd = open("./lib/crazy_list.txt", O_CREAT|O_RDWR, 0777);
    if (fd == FILE_ERROR) {
        fd = open("./lib/crazy_list.txt", O_CREAT|O_RDWR, 0777);
        if (fd == FILE_ERROR) {
            printf("crazy_file create error");
               exit(0);
        }   
    } else {
        close(fd);
    }

    return 0;
}
