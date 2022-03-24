package com.company;

import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int sec = 0;
        int processing = 0;

        PriorityQueue<Integer> waiting_jobs_queue = new PriorityQueue<Integer>();
        Queue<Integer> completed_jobs_queue = new LinkedList<>();

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] >= o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        // 첫 번재 process 추가
        processing = (jobs[0][1]);


        while (completed_jobs_queue.size() != jobs.length) {
            sec++;
            processing--;
            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][0] == sec) {
                    waiting_jobs_queue.add(jobs[i][1]);

                }
            }
            if (processing == 0) {
                completed_jobs_queue.add(sec - jobs[completed_jobs_queue.size()][0]);
                if (waiting_jobs_queue.isEmpty())
                    break;
                else
                    processing = waiting_jobs_queue.poll();
            }
        }
        System.out.println(completed_jobs_queue);

        for (int i = 0; i < jobs.length; i++) {
            answer += completed_jobs_queue.poll();
        }
        answer /= jobs.length;


        return answer;
    }
}