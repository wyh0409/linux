#ifndef _DEBUG_H_
#define _DEBUG_H_

#ifdef _DEBUG
#define DEBUG(format, ...)printf("File:"__FILE__", Line: %d :"format"\n", __LINE__, ##__VA_ARGS__)
#else
#define DEBUG(format, ...)
#endif  

#define PLAYER_FILE_ERROR (-1)
#define GUESS_FILE_ERROR  (-1)
#define CRAZY_FILE_ERROR  (-1)

#endif