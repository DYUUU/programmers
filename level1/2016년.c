#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int a, int b) {
    char* weekday[7] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    int monthday[12]={31,29,31,30,31,30,31,31,30,31,30,31};
    int day = b;
    char* answer = (char*)malloc(3);

    for(int i = 0 ; i<a-1;i++)
        day += monthday[i];

    answer = weekday[day % 7];
    return answer;
}
