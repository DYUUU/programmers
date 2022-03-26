package com.company;

public class Solution1 {
    static class Solution {
        public int targetNum;
        public long targetMin = 0;

        public void binaryFind(long left, long right, int[] times) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
            }
            if (left>right) {
                targetMin = left;
            }
            else {
                if (sum < targetNum) {
                    binaryFind(mid+1, right, times);
                } else if (sum >= targetNum) {
                    binaryFind(left, mid - 1, times);
                }
            }
        }

        public long solution(int n, int[] times) {
            targetNum = n;

            binaryFind(1, (long)Math.pow(1000000000,2), times);

            System.out.println(targetMin);

            return targetMin;
        }
    }
}
