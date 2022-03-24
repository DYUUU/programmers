package com.company;

import java.util.*;

public class Solution {
    public int sec=0;
    public int solution(int[][] jobs) {

        PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (sec-o1[0]+o1[1])-(sec-o2[0]+o2[1]);
            }
        });
        HashSet<Integer> check = new HashSet<>();

        int sum=0;
        while(check.size()!=jobs.length||!pq.isEmpty()){
            for(int i=0;i<jobs.length;i++){
                if(jobs[i][0]<=sec&&check.add(i)){
                    pq.add(jobs[i]);
                }
            }
            if(pq.size()==0){
                sec++;
                continue;
            }
            int[] tmp=pq.poll();
            sum+=sec-tmp[0]+tmp[1];
            sec+=tmp[1];
            ArrayList<int[]> ttmp= new ArrayList<>();
            while(!pq.isEmpty()){
                ttmp.add(pq.poll());
            }
            for(int[] item : ttmp){
                pq.add(item);
            }
        }

        return sum/check.size();
    }
}