#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(const char* phone_number) {
    char* answer = (char*)malloc(1);
    int len = 0; 
    
    for(int i = 0 ; phone_number[i]!='\0';i++)
        len++;
    
    for(int i = 0; i <= len;i++)
    {
         if(len-4>i)
         {
             answer[i] = '*';             
         }
        else
        {
            answer[i] = phone_number[i];
        }   
    }
    
    return answer;
}