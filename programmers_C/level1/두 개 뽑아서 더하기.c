#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int numbers[], size_t numbers_len) {
    int* answer = (int*)malloc(sizeof(int)*200);
    int tmp = 0;
    int cnt = 0;
    int flag = 0;
    
    for(int i = 0; i < numbers_len;i++)
    {
        for(int j = i+1; j < numbers_len;j++)
        {
            answer[cnt] = numbers[i] + numbers[j];
            
            //////////////// 중복 제거
            for(int k = 0;k < cnt; k++)
            {
                if(answer[cnt]==answer[k])
                {  
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                flag = 0;
            else
                cnt++;
        }
        
    }
    
    realloc(answer,sizeof(int)*cnt);
    
    for(int i = 0 ;i <cnt-1;i++)
    {
        for(int j = i+1; j<cnt;j++)
        {
            if(answer[i] > answer[j])
                {
                    tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                }
        }
    }
    
    return answer;
}
