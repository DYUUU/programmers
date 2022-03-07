package com.company;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };

        Solution sol = new Solution();
        sol.solution(lines);

    }
}
