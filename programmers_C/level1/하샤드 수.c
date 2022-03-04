#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(int x) {
    int hashad = 0;
    int num = x;
    bool answer = true;
    
    while(x>0)
    {
        hashad += x % 10;
        x /= 10;
    }
    
    if(num % hashad != 0)
        answer = false;
    
    return answer;
}