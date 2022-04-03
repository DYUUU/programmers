package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "test"};
        int[] plays = {500, 600, 150, 800, 2500, 100};

        Solution sol = new Solution();
        sol.solution(genres,plays);
    }
}
