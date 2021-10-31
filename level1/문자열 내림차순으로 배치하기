#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* s) {
    int len = strlen(s);
    char* answer = (char*)malloc(len);    
    char tmp;
    
    strcpy(answer,s);
    
    for(int i = 0; i < len-1;i++)
    {
        for(int j = i ; j < len; j++)
        {
            if(answer[i] < answer[j])
            { 
                tmp = answer[i];
                answer[i] = answer[j];
                answer[j] = tmp;
            }
        }
    }
        
    return answer;
}
