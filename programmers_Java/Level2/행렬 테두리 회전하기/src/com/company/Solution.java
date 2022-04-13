package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt = 1;
        // 맵
        int[][] matrix = new int[rows][columns];
        // 우 하 좌 상
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // matrix 그리기
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i - 1][j - 1] = cnt;
                cnt++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            // 범위
            int rotation = -1;
            int[] x1y1 = {queries[i][0] - 1, queries[i][1] - 1};
            int[] x2y2 = {queries[i][2] - 1, queries[i][3] - 1};
            // 꼭짓점
            int[][] point = {x1y1.clone(), {x1y1[0], x2y2[1]}, x2y2.clone(),
                    {x2y2[0], x1y1[1]}};
            // 움직이는 곳
            int[] dot = x1y1.clone();


            int tmp1 = 0;
            int tmp2 = 0;
            while (true) {

                for (int j = 0; j < point.length; j++) {
                    if (Arrays.equals(point[j], dot))
                        rotation++;
                }
                if (rotation == 4)
                    break;
                if (tmp1 == 0) {
                    tmp1 = matrix[dot[0]][dot[1]];
                } else
                    tmp1 = tmp2;

                dot[0] += move[rotation][0];
                dot[1] += move[rotation][1];

                tmp2 = matrix[dot[0]][dot[1]];
                matrix[dot[0]][dot[1]] = tmp1;

                pq.add(tmp1);
            }
            answer[i] = pq.peek();
            pq.clear();
        }


        return answer;
    }
}
