package com.company;

import java.util.Arrays;

public class Solution {
    public boolean[] visit;
    public int div = 0;

    public void BFS(int[] d, int budget, int total,String str, int cnt) {
        if (budget < total) {
            return;
        } else {
            for (int i = 0; i < d.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    BFS(d, budget, total + d[i], str + d[i], cnt + 1);
                }
            }
            if (cnt > div)
                div = cnt;
        }
    }

    public int solution(int[] d, int budget) {
        visit = new boolean[d.length];

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            visit[i] = true;
            BFS(d, budget, d[i], String.valueOf(d[i]),1);
        }
        System.out.println(div);

        return div;
    }
}
