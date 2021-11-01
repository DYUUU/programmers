#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// sizes_rows는 2차원 배열 sizes의 행 길이, sizes_cols는 2차원 배열 sizes의 열 길이입니다.
int solution(int** sizes, size_t sizes_rows, size_t sizes_cols) {
    int answer = 0;
    int max[1][2] = {0};
  
    for(int i = 0; i < sizes_rows;i++)
    {
        for(int j = 0; j < sizes_cols;j++)
        {
            if(sizes[i][j] > sizes[i][j+1])
            {
                if(max[0][0] < sizes[i][j])
                    max[0][0]  = sizes[i][j];
                if(max[0][1]  < sizes[i][j+1])
                    max[0][1]  = sizes[i][j+1];
            }
            else
            {
                if(max[0][1] < sizes[i][j])
                    max[0][1] = sizes[i][j];
                if(max[0][0] < sizes[i][j+1])
                    max[0][0] = sizes[i][j+1];
            }
            j++;
        }
    }
    
    answer = max[0][0] * max[0][1];
    
    return answer;
}
