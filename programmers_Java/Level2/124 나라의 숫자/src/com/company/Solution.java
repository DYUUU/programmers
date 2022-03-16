package com.company;

public class Solution {
    public StringBuilder result = new StringBuilder();
    public void DFS(int num)
    {
            int remain=num%3;
        if(num==0) {
            return;
        }
        else{
            num /= 3;
            if (remain == 0) {
                result.append(4);
                DFS(num-1);
            } else {
                result.append(remain);
                DFS(num);
            }
        }
    }

    public String solution(int n) {
        // 3진법

        DFS(n);
        String answer = String.valueOf(result.reverse());
        return answer;
    }
}
