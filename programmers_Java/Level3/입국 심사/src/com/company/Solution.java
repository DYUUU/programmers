package com.company;

import java.util.*;

public class Solution {
//
//    public void binarySearch(int[] complete, int left, int right) {
//        int mid = (left + right) / 2;
//        if (complete[left] == targetNum) {
//            targetIndex = left;
//        } else {
//            if (complete[mid] < targetNum) {
//                binarySearch(complete, mid + 1, right);
//            } else {
//                binarySearch(complete, left, mid - 1);
//            }
//        }
//
//    }

    public long solution(int n, int[] times) {
        long answer = 0;
        TreeMap<Long, int[]> timeMap = new TreeMap<>();
        int cnt = 0;

        for (int i = 0; i < times.length; i++) {
            int[] tmp;
            if (timeMap.containsKey((long) times[i])) {
                tmp = timeMap.get((long) times[i]);
                tmp[0]++;
            } else {
                tmp = new int[]{1, times[i]};
            }
            timeMap.put((long) times[i], tmp);
        }


        while (cnt < n) {
            for (long time : timeMap.keySet()) {
                answer = time;
                int[] tmpValue = timeMap.get(time);
                cnt += tmpValue[0];
                if (timeMap.containsKey(time + tmpValue[1])) {
                    tmpValue[0]++;
                }
                timeMap.put(time + tmpValue[1], tmpValue);
                timeMap.remove(time);
                break;
            }
        }

        System.out.println(answer);

        return answer;
    }
}