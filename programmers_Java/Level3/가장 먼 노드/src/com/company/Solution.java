package com.company;

import java.util.Arrays;

public class Solution {
    public boolean[] visit;
    public int num;

    public void DFS(int[][] map, int x, int y, String answer) {
        if (x == num||y==num) {
            System.out.println(answer);
            return;
        } else {
            for (int i = 0; i < num; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    if (map[x][y] == 1) {
                        DFS(map, y, x + 1, answer + " " + (y + 1));
                        DFS(map, x, y + 1, answer);
                    } else {
                        DFS(map, x, y + 1, answer);
                    }
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        num = n;
        visit = new boolean[n];
        int[][] map = new int[n][n];

        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0] - 1][edge[i][1] - 1] = 1;
            map[edge[i][1] - 1][edge[i][0] - 1] = 1;
        }

        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(map[i]));

        DFS(map, 0, 0, "1");

        return answer;
    }

}
