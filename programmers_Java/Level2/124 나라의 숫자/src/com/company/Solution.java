package com.company;

public class Solution {
    public String result = "";
    public void DFS(int num)
    {
        if(num==0) {
            return;
        }
        else{
            int remain=num%3;
            num /= 3;
            if (remain == 0) {
                result = 4 + result;
                DFS(num-1);
            } else {
                result = remain + result;
                DFS(num);
            }
        }
    }

    public String solution(int n) {
        // 3진법
        DFS(n);

        return result;
    }
}
