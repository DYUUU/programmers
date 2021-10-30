#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(long long n) {
    long long answer = 0;
    while((answer*answer)<n)
    {
        answer++;
        if(answer*answer == n)
        {
            answer = (answer+1)* (answer+1);  
            break;
        }
        else if(answer*answer > n)
        {
            answer = -1;
            break;
        }
    }
        return answer;
}