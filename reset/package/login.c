#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <ctype.h>

#include "login.h"
#include "color.h"

static int contrast_regist(char *name);


void regist(void)/*游戏注册*/
{
	int count1;
	int jump;
	struct user *regist,*player;
	FILE *fp = NULL;
	char ch;

	/*	memset(&regist, 0, sizeof(regist));
		memset(&player, 0, sizeof(player));*/

	regist = (struct user *)malloc(sizeof(struct user));
	player = (struct user *)malloc(sizeof(struct user));

	system("clear");

	printf("\n\n\t\t\tWelocm registration game\n\n");

	jump = 1;

	while (jump) {
          printf("Please enter user name[no more than 10 charaters]:");
          scanf("%s",regist->name);
          
          if (strlen(regist->name) < 10) {
             fp = fopen("./lib/player.txt", "r");
             if (!fp) {
                 printf("\t\t\topen player faile\n\n");
				 fp = fopen("./lib/player.txt", "w");
             } else {
                  fclose(fp);
                  jump = contrast_regist(regist->name);
             }
          } else {
               printf("\n\t\tIncorrect account,plesde input again\n");
          }
    }

	jump = 1;


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

	fp=fopen("./lib/player.txt","a");
	if (!fp) {
        printf("open error");
        fp = fopen("./lib/player.txt", "a");
	}
    
    fwrite(regist,sizeof(struct user),1,fp);
    fflush(fp);
    fclose(fp);

    free(regist);
    free(player);
}

/*判断注册*/
static int contrast_regist(char *name)
{

    FILE *fp = NULL;
	struct user *player;
	int jump = 1;

	fp = fopen("./lib/player.txt", "r");

	player = (struct user *)malloc(sizeof(struct user));

	while (!feof(fp)) {
           fread(player,sizeof(struct user), 1, fp);

          if (player->name == NULL) {
              jump = 0;
          } else {
               if (strcmp(player->name, name) == 0) {
                   printf("\nYour account alread exists.plase re register\n");
                   jump = 1;
               } else {
                    jump = 0;
                    break;
               }
          }
    }

	fclose(fp);
	/*	free(regist);*/
	free(player);

	return(jump);
}

/*登录*/
void logining(void)
{
	int run3 = 1;
	int count1;
	int count2 = 1;
	char ch;
	struct user *login, *player;
	FILE *fp = NULL;

	/*	memset(&player2, 0, sizeof(player2));
		memset(&login, 0, sizeof(login));*/

	login = (struct user *)malloc(sizeof(struct user));
	player = (struct user *)malloc(sizeof(struct user));

	/*	memset(&player, 0, sizeof(struct user));
		memset(&login, 0, sizeof(struct user));*/

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

}


int init(void)
{
    FILE *fp = NULL;
    int fd;
    
    if (access("./lib", F_OK) != 0) {
		mkdir("./lib", 0777);
    }
    
    fd = open("./lib", O_CREAT|O_RDWR, 0777);
	fp = fopen("./lib/player.txt", "r");
    
    if (!fp) {
        fp = fopen("./lib/player.txt", "w");
	}

	fclose(fp);
	close(fd);

    return 0;
}
