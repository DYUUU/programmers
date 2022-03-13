package com.company;


public class Solution {
    int targetNum;
    int targetIndex = 0;

    public void binarySearch(int[] complete, int left, int right) {
        int mid = (left + right) / 2;
        if (complete[left] == targetNum) {
            targetIndex = left;
        } else {
            if (complete[mid] < targetNum) {
                binarySearch(complete, mid + 1, right);
            } else {
                binarySearch(complete, left, mid - 1);
            }
        }

    }

    public long solution(int n, int[] times) {
        targetNum = n;
        long answer = 0;
        int[] complete = new int[(n * times[0]) + 1];

        int cnt = 0;

        for (int i = 1; i < complete.length; i++) {
            for (int j = 0; j < times.length; j++) {
                if (i % times[j] == 0) {
                    cnt++;
                    complete[i] = cnt;
                } else {
                    complete[i] = cnt;
                }
            }
        }

        binarySearch(complete, 0, complete.length);

        return targetIndex;
    }
}
