#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#define SWAP(a,b,tmp) {tmp = a; a=b; b=tmp; }
// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.
int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;
    int tmp;
    
    // 선택 정렬
    for(int i = 0; i < A_len-1; i++)
    {
        for(int j = i+1; j <B_len;j++)
        {
            if(A[i]<A[j])
                SWAP(A[i],A[j],tmp);
            if(B[i]>B[j])
                SWAP(B[i],B[j],tmp);
        }
    }
    
    for(int i = 0; i<A_len;i++)
    {
        answer += A[i]*B[i];
    }
    
    return answer;
}