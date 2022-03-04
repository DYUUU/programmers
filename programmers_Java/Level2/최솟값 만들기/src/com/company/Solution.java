package com.company;


import java.util.Arrays;


public class Solution {

    public int solution(int[] A, int[] B) {
        int answer =0;
        int length = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i =0;i<length;i++) {
                answer += A[i]*B[length-(i+1)];
        }

        System.out.println(answer);

        return answer;

    }
}
