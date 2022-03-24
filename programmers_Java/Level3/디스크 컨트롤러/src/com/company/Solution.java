package com.company;

import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int sec = 0;
        int processing = 0;

        Queue<int[]> jobs_queue = new LinkedList<>();
        PriorityQueue<Integer> waiting_jobs_queue = new PriorityQueue<Integer>();
        Queue<Integer> completed_jobs_queue = new LinkedList<>();

        // jobs queue에 job 넣기
        for (int i = 0; i < jobs.length; i++)
            jobs_queue.add(jobs[i]);

        // 첫 번재 process 추가
        processing = (jobs_queue.poll()[1]);

        while (completed_jobs_queue.size() != jobs.length) {
            sec++;
            processing--;
            for (int i = 0; i < jobs_queue.size(); i++) {
                if (jobs_queue.peek()[0] == sec) {
                    waiting_jobs_queue.add(jobs_queue.poll()[1]);

                }
            }
            if (processing == 0) {
                completed_jobs_queue.add(sec);
                if (waiting_jobs_queue.isEmpty() && jobs_queue.isEmpty())
                    break;
                else
                    processing = waiting_jobs_queue.poll();
            }
        }

        System.out.println(completed_jobs_queue);

        return answer;
    }
}