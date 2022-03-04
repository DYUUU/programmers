#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* s) {
    int len = strlen(s);
    char* answer = (char*)malloc(3);
    
    for(int i = 0 ; i < 3 ; i++)
        answer[i] = NULL;
    
    if(len%2==0)
    {
        answer[0] = s[len / 2 - 1];
        answer[1] = s[len / 2];
    }
    else
    {
        answer[0] = s[len/2];
    }
    
    return answer;
}
