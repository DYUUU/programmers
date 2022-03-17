package com.company;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> result = new PriorityQueue();

        for(int i : scoville)
        {
            result.add(i);
        }

        while(result.peek()<K)
        {
            answer++;
            result.add(result.poll()+(result.poll()*2));
        }

        System.out.println(answer);
        return answer;
    }
}
