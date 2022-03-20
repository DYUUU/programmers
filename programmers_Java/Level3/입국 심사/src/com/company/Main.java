package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n =  1000000000;
        int[] times= new int[100000];

        Arrays.fill(times, 1000000000);

        Solution sol = new Solution();
//        sol.solution(n,times);
        sol.solution(5,new int[]{2,2});
    }
}
