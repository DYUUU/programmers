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
        long[][] timeList = new long[times.length][2];
        int cnt = 0;

        for (int i = 0; i < times.length; i++) {
            timeList[i][0] = times[i];
            timeList[i][1] = times[i];
        }

        while (cnt != n) {
            Arrays.sort(timeList, new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return (int) (o1[0] - o2[0]);
                }
            });
            answer = timeList[0][0];
            timeList[0][0] += timeList[0][1];
            cnt++;
        }

        System.out.println(answer);

        return answer;
    }
}