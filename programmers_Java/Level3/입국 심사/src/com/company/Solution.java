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
        ArrayList<long[][]> timeList = new ArrayList<>();
        int cnt = 0;
        boolean flag = false;

        for (int i = 0; i < times.length; i++) {
            if (timeList.size() > 0) {
                for (int j = 0; j < timeList.size(); j++) {
                    if (times[i] == timeList.get(j)[0][0]) {
                        timeList.get(j)[0][1] += 1;
                        flag = true;
                    }
                }
            }
            if (!flag) {
                long[][] tmp = new long[1][3];
                tmp[0][0] = times[i];
                tmp[0][1] = 1;
                tmp[0][2] = times[i];
                timeList.add(tmp);
            }
            flag = false;
        }


        while (cnt != n) {
            timeList.sort(new Comparator<long[][]>() {
                @Override
                public int compare(long[][] o1, long[][] o2) {
                    return (int) (o1[0][0] - o2[0][0]);
                }
            });
            answer = timeList.get(0)[0][0];
            cnt += timeList.get(0)[0][1];
            timeList.get(0)[0][0] += timeList.get(0)[0][2];
        }

        System.out.println(answer);

        return answer;
    }
}