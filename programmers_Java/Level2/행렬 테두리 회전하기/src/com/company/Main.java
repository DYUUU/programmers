package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        Solution sol = new Solution();

        sol.solution(rows,columns,queries);

    }
}
