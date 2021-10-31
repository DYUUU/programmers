#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(const char* s) {
    int answer = 0;
    int flag = 0;

    for(int i = 0 ; s[i] != '\0'; i++)
    {
        if(s[i] == '-')
            flag = 1;
        else if(s[i]>='0' && s[i] <= '9')
        {
            answer = (answer + (s[i] - 48));
            if(s[i+1]>='0' && s[i+1] <= '9')
                answer *= 10;
        }
    }
    
    if(flag)
        answer *= -1;
    
    return answer;
}
