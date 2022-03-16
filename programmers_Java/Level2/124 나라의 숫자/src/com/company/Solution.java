package com.company;

public class Solution {


    public String solution(int n) {
        String answer = "";
        int remain;
        int num = n;
        // 3진법
        while (num != 0) {
            remain = num % 3;
            num /= 3;
            if (remain == 0) {
                answer = 4 + answer;
                num--;
            } else {
                answer = remain + answer;
            }
        }
        System.out.println(answer);


        return answer;
    }
}
