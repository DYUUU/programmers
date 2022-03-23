package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        Solution sol = new Solution();

        sol.solution(user_id,banned_id);
    }
}
