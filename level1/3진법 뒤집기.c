#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>

int solution(int n) 
{
    int answer = 0;
    long tmp = 0;
    // 길이가 길어서 long으로 주어야 한다.
    
    for(int i = 0 ; n > 0; i++)
    {
        tmp = tmp + (n % 3);
        n /= 3;
        if(n > 0)
            tmp *= 10;
    }
    
    for(int i = 0; tmp > 0; i++)
    {
        answer = answer + (tmp % 10) * (pow(3,i));
        tmp /= 10;
    }
    
    return answer;
}
