package com.company;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here
        int n = 6;
        int[] times = {7,10};

//        Solution1.Solution sol1 = new Solution1.Solution();
//        sol1.solution(n,times);

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        Solution sol2 = new Solution();
        sol2.solution(play_time,adv_time,logs);


    }
}
