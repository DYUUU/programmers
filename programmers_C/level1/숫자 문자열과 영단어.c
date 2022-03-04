#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    char* num[10] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    int answer = 0;
    char tmp[5] = {'\0'};
    int cnt = 0;
    for(int i = 0; s[i]!='\0';i++)
    {
        if(s[i]>='A' && s[i] <= 'z')
        {       
            cnt++;
            for(int j = 0; j < 10; j++)
            {
                for(int k = 0; k < strlen(num[j]);k++)
                {
                    tmp[k] = s[i + k];
                }
                if(strncmp(tmp,num[j],strlen(num[j]))==0)
                {    
                    answer += j;
                    i += strlen(num[j])-1;
                    if(s[i+1]!='\0')
                        answer*=10;
                    break;
                }   
            }
        }
        else
        {
            answer += s[i] - 48;
            if(s[i+1]!='\0')
                answer*= 10;
        }
    }
    
    return answer;
}
