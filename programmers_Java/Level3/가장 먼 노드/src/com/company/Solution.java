package com.company;

import java.util.Arrays;

public class Solution {
    public boolean[] visit;
    public int num;

    public void DFS(boolean[][] map, int x, int y, String answer) {
        if (x == num || y == num) {
                        System.out.println(answer);
            return;
        } else {
                    if (map[x][y]) {
                        map[x][y] = false;
                        DFS(map, y, x + 1, answer + " " + (y + 1));
                        int tmp = y;
                        while(!map[x][y])
                        {
                            y++;
                            if(y==num)
                                break;
                        }
                        DFS(map, x, y, answer);
                    } else {
                        while(!map[x][y])
                        {
                            y++;
                            if(y==num)
                                break;
                        }
                        DFS(map, x, y, answer);
                    }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        num = n;
        visit = new boolean[n];
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0] - 1][edge[i][1] - 1] = true;
            map[edge[i][1] - 1][edge[i][0] - 1] = true;
        }

        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(map[i]));

        DFS(map, 0, 0, "1");

        return answer;
    }

}
