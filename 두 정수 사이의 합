#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long sum (int a, int b);
long long solution(int a, int b) {
    long long answer = 0;
    if(a==b) 
        answer = a;
    else if(a>b) 
        answer = sum(b,a);
    else if(a<b)
        answer = sum(a,b);
    return answer;
}

long long sum (int a, int b)
{
    if(b == a) 
        return b;
    else
        return b + sum(a,b-1);
}
