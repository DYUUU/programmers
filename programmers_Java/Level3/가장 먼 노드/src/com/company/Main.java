package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 6;
        int[][] vertex = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}
                , {1, 2}, {2, 4}, {5, 2}};

        Solution sol = new Solution();
        sol.solution(n,vertex);
    }
}
