package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    public ArrayList<Integer> dist = new ArrayList<>();
    public boolean[] visit;

    public void BFS(int x, int y, String answer) {
        for (int i = 0; i < nodes.get(y).size(); i++) {
            if (!visit[x]) {
                visit[x] = true;
                BFS(y, nodes.get(y).get(i), answer+" " +y);
                System.out.println(answer);
                visit[x] = false;
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new boolean[n + 1];

        for (int i = 0; i < edge.length; i++) {
            nodes.add(new ArrayList<Integer>());
            dist.add(Integer.MAX_VALUE);
        }

        for (int[] distance : edge) {
            nodes.get(distance[1]).add(distance[0]);
            nodes.get(distance[0]).add(distance[1]);
        }

        for (int i = 0; i < nodes.get(1).size(); i++) {
            BFS(1, nodes.get(1).get(i), "1");
        }

        System.out.println(dist);


        return answer;
    }

}
