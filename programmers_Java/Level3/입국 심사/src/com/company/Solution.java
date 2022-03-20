package com.company;


public class Solution {
    public long targetNum;
    public long targetIndex = 0;

    public void binarySearch(int[] times, int left, int right) {
        int mid = (left + right) / 2;
        int sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += (mid / times[i]);
        }
        if (right<left) {
            targetIndex = left;
        }
        else if (sum < targetNum) {
            binarySearch(times, mid + 1, right);
        } else if (sum >= targetNum) {
            binarySearch(times, left, mid - 1);
        }

    }

    public long solution(int n, int[] times) {
        targetNum = n;

        binarySearch(times, 0, 1000000000);
        System.out.println(targetIndex);
        return targetIndex;
    }
}