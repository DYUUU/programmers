#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int divisor_cnt (int num);

int solution(int left, int right) {
    int answer = 0;

    // 약수의 개수 구하기
    for(int i = left ; i <= right; i++)
    {
        if(divisor_cnt(i)%2 == 0)
            answer+=i;
        else
            answer-=i;
    }
    return answer;
}

int divisor_cnt (int num)
{
    int cnt = 0;
    for(int i = 1; i <= num; i++)
    {
        if(num%i==0)
            cnt++;
    }
    return cnt;
}
