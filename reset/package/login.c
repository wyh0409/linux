
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


/**
 * @brief   游戏注册   
 * @return: 成功返回0
 *          失败返回-1
 */
int regist(void)
{
	int count_pwd;
	int jump;
	struct user *regist,*player;
	FILE *fp = NULL;
	char ch;
    int return_value = 0;

	regist = (struct user *)malloc(sizeof(struct user));
	player = (struct user *)malloc(sizeof(struct user));

	system("clear");

	printf("\n\n\t\t\tWelcome registration game\n\n");

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
                    return_value = PLAYER_FILE_ERROR;
                }
                
            } else {
                fclose(fp);
                jump = contrast_regist(regist->name);
            }
        } else {
            printf("\n\t\tIncorrect account,please input again\n");
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
        
        for (count_pwd = 0; count_pwd < 8; count_pwd++) {
            regist->password[count_pwd] = getchar();
            /*判断密码输入*/
            if (isalpha(regist->password[count_pwd]) != 0
                || isdigit(regist->password[count_pwd]) != 0) {

                printf("*");
            } else {
                count_pwd = count_pwd-1;
                printf("\n\t\tenter error ");
            }
        }

        system("stty echo");
        system("stty icanon");
        system("stty -igncr");
        
        jump = 0;
	}

	fp = fopen("./lib/player.txt", "a");
	if (!fp) {
        DEBUG("open error\n");
        fp = fopen("./lib/player.txt", "a");
        if (!fp) {
            return_value = PLAYER_FILE_ERROR;
        }
        
	}
    
    fwrite(regist,sizeof(struct user), 1, fp);
    fflush(fp);
    fclose(fp);

    free(regist);
    free(player);

    return (return_value);
}

/**
 * @brief    判断注册
 * @return:  成功返回0
 *           失败返回1 
 */
static int contrast_regist(char *name)
{
    FILE *fp = NULL;
	struct user *player;
	int jump = 1;

	fp = fopen("./lib/player.txt", "r");
    rewind(fp);
    
	player = (struct user *)malloc(sizeof(struct user));

	while (!feof(fp)) {
        fread(player,sizeof(struct user), 1, fp);
        if (player->name == NULL) {
            jump = 0;
        } else {
            if (strcmp(player->name, name) == 0) {
                printf("\nYour account already exists.please re register\n");
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

/**
 * @brief:      账户登录 
 * @return:     成功返回0
 *              失败返回-1 
 */
int logining(void)
{
	int jump = 1;
	int count_pwd;
	int pwd_input_count = 1;
    int return_value = 0;
	char ch;
	struct user *login, *player;
	FILE *fp = NULL;

	login = (struct user *)malloc(sizeof(struct user));
	player = (struct user *)malloc(sizeof(struct user));

	system("clear");

	while (jump) {
          printf("\n\n\t\t\tWelcome login game\n\n");
          printf("\t\tenter user name:");
          scanf("%s", login->name);

          printf("\n\t\tenter your password:");
          system("stty -icanon");
          system("stty -echo");
          system("stty igncr");
          
          while ((ch = getchar()) != '\n' && ch != EOF);
          
          for (count_pwd = 0; count_pwd < 8; count_pwd++) {
              login->password[count_pwd] = getchar();
              /*判断密码输入*/
              if (isdigit(login->password[count_pwd]) != 0
                 || isalpha(login->password[count_pwd]) != 0) {
                  printf("*");
              } else {
                   count_pwd = count_pwd-1;
                   printf("\n\t\tenter error");
              }
          }

          system("stty icanon");
          system("stty echo");
          system("stty -igncr");
          
          fp = fopen("./lib/player.txt", "r");
          if (!fp) {
              return_value = PLAYER_FILE_ERROR;
          }
          
          rewind(fp);
          
          while (!feof(fp)) {
                fread(player,sizeof(struct user), 1, fp);
                if(strcmp(player->name, login->name) == 0 &&
                   strcmp(player->password, login->password) == 0) {
                   printf("\n\n\t\tWelcome stareturn_value game\n\n");
                   jump = 0;
                   break;
                }	
          }
          fclose(fp);
          
          if (jump == 1) {
              printf("\n\n\t\t Login error \n\n");
              pwd_input_count = pwd_input_count+1;
          } else {
                  continue;
          }
       
          if (pwd_input_count > 3) {
              exit(0);
              break;
          }  else {
               continue;
          }
	}

	free(login);
	free(player);

    return return_value;
}


/**
 * @brief       初始化 
 * @return:     成功返回0
 */
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
