#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    long answer = 0;
    int* arr= (int*)malloc(sizeof(int)*(n+1));
    
    
    for(int i = 0;i <= n;i++)
    {
        if(i<=1)
            arr[i]=i;
        else
        {
                arr[i] = (arr[i-2] + arr[i-1]) % 1234567 ;
        }
    }
    
    answer = arr[n];
    
    return answer;
}
