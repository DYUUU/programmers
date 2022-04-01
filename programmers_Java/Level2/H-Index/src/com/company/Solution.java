package com.company;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < citations.length; i++)
            pq.add(citations[i]);

        for (int i = 0; i <= citations.length; i++) {
            if (pq.peek() >= i) {
                if (pq.size() >= i) {
                    answer =i;
                }
            } else {
                pq.poll();
            }
        }

        System.out.println(answer);

        return answer;
    }
}