#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    int size = strlen(s);
    char* answer = (char*)malloc(size);
    int cnt = 0;
    
    for(int i = 0; i<=size;i++)
    {
        answer[i] = s[i];
        if (s[i] == 32)
        {
            cnt = 0;
            continue;
        }
         
        if(cnt%2 == 0)
            answer[i] = toupper(s[i]);
        else
            answer[i] = tolower(s[i]);
        cnt++;
    }
    
    return answer;
}