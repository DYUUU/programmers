package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<double[]> result = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1])
                    return (int) (o1[0] - o2[0]);
                return (int) (o2[1] * 1000 - o1[1] * 1000);
            }
        });

        for (int i = 0; i < stages.length; i++)
            pq.add(stages[i]);

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            int users = pq.size();
            if(!pq.isEmpty()){
            while (pq.peek() == i) {
                pq.poll();
                cnt++;
                if (pq.isEmpty())
                    break;
            }}
            if (users == 0)
                result.add(new double[]{i, 0});
            else
                result.add(new double[]{i, (double) cnt / users});
        }

        for (int i = 0; i < N; i++)
            answer[i] = (int) result.poll()[0];

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
