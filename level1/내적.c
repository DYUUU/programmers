#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a[], size_t a_len, int b[], size_t b_len) {
    int answer = 0;
    int i ,j = 0;
    
    while(i < a_len && j < b_len)
    {
        answer += a[i] * b[j];
        i++;
        j++;
    }
    
    return answer;
}
