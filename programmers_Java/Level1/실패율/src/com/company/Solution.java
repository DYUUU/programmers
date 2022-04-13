package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<double[]> fail = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1])
                    return (int) (o1[0] - o2[0]);
                return (int) (o2[1] * Long.MAX_VALUE - o1[1] *  Long.MAX_VALUE);
            }
        });

        for (int i = 0; i < stages.length; i++)
            pq.add(stages[i]);

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            int users = pq.size();
            while (!pq.isEmpty()&&pq.peek() == i) {
                pq.poll();
                cnt++;
            }
            if (users != 0)
                fail.add(new double[]{i, (double) cnt / users});
            else
                fail.add(new double[]{i, 0.0});
        }

        int i = 0;
        while (!fail.isEmpty()) {
            answer[i] = (int) fail.poll()[0];
            i++;
        }

        System.out.println(Arrays.toString(answer));


        return answer;
    }
}
