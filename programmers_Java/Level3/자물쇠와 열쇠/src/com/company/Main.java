package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}};
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        Solution sol = new Solution();
        sol.solution(key,lock);
    }

}
