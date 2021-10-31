#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(int n) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    int size = sizeof(int)*n;
    char* answer = (char*)malloc(size);
    
    for(int i = 0 ; i < size; i++)
        answer[i] = NULL;
    for(int i = 0; i < n; i++)
    {
        if(i%2 == 0)
            strcat(answer,"수");
        else
            strcat(answer,"박");
    }
    
    return answer;
}
