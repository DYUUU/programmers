#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
bool solution(const char* s) {
    bool answer = true;
    int len = 0;

    for(int i = 0 ; s[i] != '\0'; i++) 
        len++;
    
    if(len == 4 || len == 6)
    {
        for(int i = 0 ; i < len ;i++)
        {
            if(s[i] >= 'A' && s[i] <= 'Z' ||
              s[i] >= 'a' && s[i] <= 'z')
            {
                answer = false;
                break;
            }
        }
    }
    else
        answer = false;
        
    return answer;
}
