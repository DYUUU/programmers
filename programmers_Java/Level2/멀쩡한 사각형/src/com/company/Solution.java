package com.company;

public class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int[][] noRectangle;
        answer = (long) w * h;
        int cnt = 0;
        int i=0;int j=0; int k=0;

        if(w==h)
        {
            answer-=w;
        }
        else if(w<h) {
            noRectangle = new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}};
            while (i < h && j < w) {
                cnt++;
                noRectangle[k][0] += 3;
                noRectangle[k][1] += 2;
                k++;
                if (k <= 3) {
                    i = noRectangle[k][0];
                    j = noRectangle[k][1];
                } else {
                    k = 0;
                    i = noRectangle[k][0];
                    j = noRectangle[k][1];
                }
            }
            answer-=cnt;
        }
        else if(w>h)
        {
            noRectangle = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
            while (i < h && j < w) {
                cnt++;
                noRectangle[k][0] += 2;
                noRectangle[k][1] += 2;
                k++;
                if (k <= 3) {
                    i = noRectangle[k][0];
                    j = noRectangle[k][1];
                } else {
                    k = 0;
                    i = noRectangle[k][0];
                    j = noRectangle[k][1];
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}
