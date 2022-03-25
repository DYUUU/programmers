package com.company;

import java.time.Period;
import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        ArrayList<Integer> check= new ArrayList<>();
        int answer=0;
        int sec = 0;
        boolean[] use = new boolean[jobs.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        while(check.size()!=jobs.length)
        {
            for(int i = 0;i<jobs.length;i++)
            {
                if(sec>=jobs[i][0]&&use[i]==false) {
                    pq.add(jobs[i]);
                    use[i]=true;
                }
            }
            if(pq.isEmpty())
                sec++;
            else
            {
                check.add(sec-pq.peek()[0]+pq.peek()[1]);
                sec+=pq.poll()[1];
            }
        }

        for(int i : check)
        {
            answer+=i;
        }

        answer/=jobs.length;

        System.out.println(answer);

        return answer;

    }
}