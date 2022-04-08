package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] id_list = {"con", "ryan"};
        String[] report = {
                "ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        Solution sol = new Solution();

        sol.solution(id_list,report,k);
    }
}
